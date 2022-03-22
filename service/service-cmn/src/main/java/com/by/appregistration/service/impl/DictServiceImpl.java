package com.by.appregistration.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.by.appregistration.mapper.DictMapper;
import com.by.appregistration.model.cmn.Dict;
import com.by.appregistration.service.DictService;
import org.springframework.stereotype.Service;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName HospitalSetServiceImpl
 * @description: TODO
 * @date 2022/3/11 0:40
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    //service调用mapper，ServiceImpl中已经注入了
}
