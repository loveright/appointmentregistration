package com.by.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouboyang
 * @version 1.0
 * @ClassName TestWrite
 * @description: TODO
 * @date 2022/3/27 19:11
 */
public class TestWrite {

    public static void main(String[] args) {
        //设置文件路径和文件名称
        String fileName = "D:\\excel\\01.xlsx";

        List<UserData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserData userData = new UserData();
            userData.setUid(i);
            userData.setUsername("lucy" + i);
            list.add(userData);
        }

        //实现写操作
        EasyExcel.write(fileName, UserData.class).sheet("用户信息")
                .doWrite(list);
    }
}
