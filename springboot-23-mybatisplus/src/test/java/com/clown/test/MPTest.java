package com.clown.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.clown.mp.MybatisPlusApplication;
import com.clown.mp.mapper.EmployeeMapper;
import com.clown.mp.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: Richard
 * @date: 2020/5/17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class MPTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testSelect() {
        List<Employee> employeeList = employeeMapper.selectList(null);
        employeeList.forEach(System.out::println);
    }

    //使用条件构造器查询  年龄 18-25 性别:男 姓名为XX 的用户
    @Test
    public void findByEntityWrapperTest() {
        employeeMapper.selectPage(
                new Page<>(1, 2),
                new EntityWrapper<Employee>()
                        .between("age", 18, 75)
                        .eq("gender", 1)
                        .eq("last_name", "王8"))
                .stream().forEach(System.out::println);

    }

    /**
     * 性别:女
     * 名字带有老师
     * 或邮箱中有tokyo
     */
    @Test
    public void wrapperTest() {
        employeeMapper.selectList(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
                        .like("last_name", "老师")
                        //.or()       WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
                        .orNew() //   WHERE (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
                        .like("email", "Tokyo")
        ).stream().forEach(System.out::println);
    }

    /**
     * 更新
     */
    @Test
    public void wrapperTest03() {
        Employee employee = new Employee();
        employee.setLastName("小泽玛利亚老师");
        employee.setEmail("小泽玛利亚@TokyoHot.com");
        employee.setGender(0);
        employee.setAge(18);

        employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                        .eq("last_name", "tom")
                        .eq("age", 44));
    }

    /**
     * 删除
     */
    @Test
    public void wrapperTest04() {
        employeeMapper.delete(
                new EntityWrapper<Employee>()
                        .eq("last_name", "小泽玛利亚老师")
                        .eq("age", 44));
    }

    @Test
    public void wrapperTest05() {
        employeeMapper.selectList(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
                        .orderBy("age")
                        //.orderDesc(Arrays.asList(new String[]{"age"})))
                        .last("desc limit 1,3"))
                .stream()
                .forEach(System.out::println);
    }


    @Test
    public void conditionTest01(){
        employeeMapper.selectPage(
                new Page<Employee>(1,2),
                Condition.create()
                        .between("age",18,45)
                        .eq("gender",0)
                        .eq("last_name","苍井空老师"))
                .stream()
                .forEach(System.out::println);
    }

}
