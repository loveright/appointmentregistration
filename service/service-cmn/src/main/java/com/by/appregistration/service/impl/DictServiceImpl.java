package com.by.appregistration.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.by.appregistration.listener.DictListener;
import com.by.appregistration.mapper.DictMapper;
import com.by.appregistration.model.cmn.Dict;
import com.by.appregistration.service.DictService;
import com.by.appregistration.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName HospitalSetServiceImpl
 * @description: TODO
 * @date 2022/3/11 0:40
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    // service调用mapper，ServiceImpl中已经注入了
    // 查询子列表
    @Override
    @Cacheable(value = "dict",keyGenerator = "keyGenerator")
    public List<Dict> findChildData(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper();
        wrapper.eq("parent_id", id);
        List<Dict> dictList = baseMapper.selectList(wrapper);
        // 向集合中每个对象设置hasChildren
        dictList.forEach(dict -> {
            Long dictId = dict.getId();
            boolean isHaveChildren = this.isHaveChildren(dictId);
            dict.setHasChildren(isHaveChildren);
        });
        return dictList;
    }

    @Override
    public void exportDictData(HttpServletResponse response) {

        try {
            // 设置下载内容
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("数据字典", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename="+ fileName + ".xlsx");
            // 查询全部
            List<Dict> dictList = baseMapper.selectList(null);
            // dict -- DictEeVo
            List<DictEeVo> dictEeVoList = new ArrayList<>();
            dictList.forEach(dict -> {
                DictEeVo dictEeVo = new DictEeVo();
                BeanUtils.copyProperties(dict,dictEeVo);
                dictEeVoList.add(dictEeVo);
            });
            // 调用方法进行写操作
            try {
                EasyExcel.write(response.getOutputStream(), DictEeVo.class).sheet("dict")
                        .doWrite(dictEeVoList);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    // 导入数据字典
    @Override
    @CacheEvict(value = "dict",allEntries = true)
    public void importDictData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),DictEeVo.class,new DictListener(dictMapper)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 判断id下是否有子节点，此id为父id
    private boolean isHaveChildren(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper();
        wrapper.eq("parent_id", id);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;
    }

}
