package com.clown.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Richard Ackerman
 * @create: 2020/5/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoDataWrite {
    //设置exxcel表头
    @ExcelProperty("学生编号")
    private Integer sno;

    @ExcelProperty("学生姓名")
    private String sname;
}
