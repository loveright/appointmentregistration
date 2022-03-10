package com.by.appregistration.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.by.appregistration.mapper.HospitalSetMapper;
import com.by.appregistration.model.hosp.HospitalSet;
import com.by.appregistration.service.HospitalSetService;
import org.springframework.stereotype.Service;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName HospitalSetServiceImpl
 * @description: TODO
 * @date 2022/3/11 0:40
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
    //service调用mapper，ServiceImpl中已经注入了
}
