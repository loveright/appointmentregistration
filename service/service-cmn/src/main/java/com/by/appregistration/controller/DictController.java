package com.by.appregistration.controller;

import com.by.appregistration.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName DictController
 * @description: TODO
 * @date 2022/3/22 22:26
 */
@RestController
@RequestMapping("/admin/cmn/dict")
public class DictController {

    @Autowired
    private DictService dictService;
}
