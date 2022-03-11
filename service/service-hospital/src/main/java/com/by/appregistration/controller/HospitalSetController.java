package com.by.appregistration.controller;

import com.by.appregistration.model.hosp.HospitalSet;
import com.by.appregistration.service.HospitalSetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName HospitalSetController
 * @description: TODO
 * @date 2022/3/11 0:52
 */
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Autowired
    HospitalSetService hospitalSetService;

    //查询医院设置表所有信息
    @ApiOperation(value = "获取所有医院设置")
    @GetMapping("findAll")
    public List<HospitalSet> findAllHospitalSet(){
        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "逻辑删除医院设置")
    public boolean removeHospSet(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        return flag;
    }
}
