package com.clown.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.clown.easyexcel.entity.DemoDataRead;

import java.util.Map;

/**
 * @author: Richard Ackerman
 * @create: 2020/5/28
 **/
public class EasyExcelListener extends AnalysisEventListener<DemoDataRead> {
    //一行一行的的读取
    @Override
    public void invoke(DemoDataRead data, AnalysisContext context) {
        System.out.println("----"+data);
    }

    //读取表头
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("---表头------"+headMap);
    }


    //读取完成之后的方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
