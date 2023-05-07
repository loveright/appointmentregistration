package com.by.appregistration.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.by.appregistration.model.cmn.Dict;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {

    // 根据id查询子列表
    List<Dict> findChildData(Long id);

    void exportDictData(HttpServletResponse response);

    void importDictData(MultipartFile file);

    //根据dictcode和value查询
    String getDictName(String dictCode, String value);

    //根据dictCode获取下级节点
    List<Dict> findByDictCode(String dictCode);
}
