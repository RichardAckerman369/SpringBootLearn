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
public class DemoDataRead {
    //设置exxcel表头
    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;
}
