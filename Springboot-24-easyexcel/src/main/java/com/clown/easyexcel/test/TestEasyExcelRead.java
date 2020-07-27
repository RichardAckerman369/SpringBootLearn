package com.clown.easyexcel.test;

import com.alibaba.excel.EasyExcel;
import com.clown.easyexcel.entity.DemoDataRead;
import com.clown.easyexcel.listener.EasyExcelListener;

/**
 * @author: Richard Ackerman
 * @create: 2020/5/28
 **/
public class TestEasyExcelRead {
    public static void main(String[] args) {
        //实现读操作
        String filename = "G:\\IDEASpace\\SpringBootLearn\\Springboot-24-easyexcel\\doc\\write.xlsx";
        EasyExcel.read(filename, DemoDataRead.class,new EasyExcelListener()).sheet().doRead();
    }
}
