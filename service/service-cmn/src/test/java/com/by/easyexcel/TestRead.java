package com.by.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName TestRead
 * @description: TODO
 * @date 2022/3/29 22:42
 */
public class TestRead {

    public static void main(String[] args) {
        String fileName = "D:\\excel\\01.xlsx";
        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet().doRead();
    }
}
