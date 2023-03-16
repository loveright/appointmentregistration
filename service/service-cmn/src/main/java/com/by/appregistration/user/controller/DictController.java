package com.by.appregistration.user.controller;

import com.by.appregistration.common.result.Result;
import com.by.appregistration.model.cmn.Dict;
import com.by.appregistration.user.service.DictService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName DictController
 * @description: TODO
 * @date 2022/3/22 22:26
 */
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    // 根据id查询子列表
    @ApiOperation(value = "根据id查询子列表数据")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }

    // 数据字典导出接口
    @GetMapping("exportData")
    public void exportDict(HttpServletResponse response) {
        dictService.exportDictData(response);
    }

    // 数据字典导入接口
    @ApiOperation(value = "导入")
    @PostMapping("importData")
    public Result importDictData(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }
}
