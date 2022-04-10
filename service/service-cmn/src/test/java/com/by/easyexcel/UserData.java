package com.by.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName UserData
 * @description: TODO
 * @date 2022/3/27 19:02
 */
@Data
public class UserData {

    @ExcelProperty(value = "用户编号",index = 0)
    private int uid;

    @ExcelProperty(value = "用户名称",index = 1)
    private String username;
}
