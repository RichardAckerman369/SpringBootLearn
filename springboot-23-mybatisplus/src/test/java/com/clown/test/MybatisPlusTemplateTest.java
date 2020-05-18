package com.clown.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author: Richard
 * @date: 2020/5/18
 **/
public class MybatisPlusTemplateTest {

    @Test
    public void test(){
        //1.全局策略配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)    //是否支持AR
                .setAuthor("Richard")     //作者
                .setOutputDir("G:\\IDEASpace\\SpringBootLearn\\springboot-23-mybatisplus\\src\\main\\java")//生成路径
                .setFileOverride(true)  //文件是否覆盖
                .setIdType(IdType.AUTO) //主键策略
                //.setServiceName("%sService")
                .setBaseResultMap(true) //
                .setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/springboot-mybatis-plus?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false")
                .setUsername("root")
                .setPassword("123456");

        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true) //全局大小写
                .setDbColumnUnderline(true)//是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                .setTablePrefix("tb_")//表前缀
                .setInclude("tb_user");//要生成的表
        //4.包策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setParent("com.clown.mp")
                .setMapper("mapper")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setEntity("model")
                .setXml("mapper");
        //整合
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //执行
        autoGenerator.execute();
    }
}
