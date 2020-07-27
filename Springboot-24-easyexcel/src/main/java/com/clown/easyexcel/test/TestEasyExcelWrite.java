package com.clown.easyexcel.test;

import com.alibaba.excel.EasyExcel;
import com.clown.easyexcel.entity.DemoDataWrite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Richard Ackerman
 * @create: 2020/5/28
 **/
public class TestEasyExcelWrite {
    public static void main(String[] args) {
        //实现excel写操作
        //1.设置写入文件夹的地址和excel名称
        String filename = "G:\\IDEASpace\\SpringBootLearn\\Springboot-24-easyexcel\\doc\\write.xlsx";

        //2调用easyexcel方法
        EasyExcel.write(filename, DemoDataWrite.class).sheet("学生列表").doWrite(getData());

    }


    private static List<DemoDataWrite> getData(){
        ArrayList<DemoDataWrite> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoDataWrite data = new DemoDataWrite(i,"盖伦"+i);
            list.add(data);
        }
        return list;
    }
}