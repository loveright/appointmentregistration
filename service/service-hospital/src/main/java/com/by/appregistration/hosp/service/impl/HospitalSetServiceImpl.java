package com.by.appregistration.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.by.appregistration.common.exception.AppRegistrationException;
import com.by.appregistration.common.result.ResultCodeEnum;
import com.by.appregistration.hosp.mapper.HospitalSetMapper;
import com.by.appregistration.model.hosp.HospitalSet;
import com.by.appregistration.hosp.service.HospitalSetService;
import com.by.appregistration.vo.order.SignInfoVo;
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

    //2 根据传递过来医院编码，查询数据库，查询签名
    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        wrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);
        return hospitalSet.getSignKey();
    }

    @Override
    public SignInfoVo getSignInfoVo(String hoscode) {
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        wrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(wrapper);
        if(null == hospitalSet) {
            throw new AppRegistrationException(ResultCodeEnum.HOSPITAL_OPEN);
        }
        SignInfoVo signInfoVo = new SignInfoVo();
        signInfoVo.setApiUrl(hospitalSet.getApiUrl());
        signInfoVo.setSignKey(hospitalSet.getSignKey());
        return signInfoVo;
    }

}
