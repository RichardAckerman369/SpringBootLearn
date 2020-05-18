package com.clown.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.clown.mp.MybatisPlusApplication;
import com.clown.mp.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard
 * @date: 2020/5/18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class ActiveRecordTest {

    /**
     * AR 添加
     */
    @Test
    public void insertTest(){
        Employee employee = new Employee();
        employee.setId(16);
        employee.setLastName("clown");
        employee.setGender(1);
        employee.setAge(25);
        employee.setEmail("clown@16.com");
        employee.insert();
    }

    /**
     * AR 更新
     */
    @Test
    public void updateTest(){
        Employee employee = new Employee();
        employee.setId(16);
        employee.setLastName("joker");
        employee.setGender(1);
        employee.setAge(30);
        employee.setEmail("joker@16.com");
        employee.updateById();
    }

    /**
     * AR 查询
     */
    @Test
    public void selectTest(){
        Employee employee = new Employee();
//        employee.setId(16);
//        employee.selectById();
//        System.out.println(employee.selectById(16));
//        employee.selectAll().stream().forEach(System.out::println);
//        employee.selectList(new EntityWrapper<Employee>()
//                .like("last_name","老师"))
//                .stream()
//                .forEach(System.out::println);
        System.out.println(employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0)));
    }

    /**
     * AR 删除
     */
    @Test
    public void deleteTest(){
        Employee employee = new Employee();
//        employee.setId(16);
//        employee.deleteById();
//        employee.deleteById(16);
        employee.delete(new EntityWrapper<Employee>().like("last_name","jo"));
    }

    /**
     * AR 分页查询
     */
    @Test
    public void pageTest(){
        Employee employee = new Employee();
        employee.selectPage(
                new Page<>(1,2),
                new EntityWrapper<Employee>()
                        .like("last_name","老师"))
        .getRecords()
                .stream()
                .forEach(System.out::println);
    }

}
