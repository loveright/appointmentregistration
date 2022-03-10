package com.by.appregistration.controller;

import com.by.appregistration.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
