package com.clown.mp.controller;

import com.clown.mp.common.Result;
import com.clown.mp.common.StatusCode;
import com.clown.mp.model.Employee;
import com.clown.mp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Richard
 * @date: 2020/5/17
 **/
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/findAll")
    public Result findAll() {
        List<Employee> employeeList = employeeService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", employeeList);
    }

    @GetMapping("findById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", employee);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PostMapping("/search")
    public Result findBySearch(@RequestBody Employee employee) {
        Employee employeeServiceByCondition = employeeService.findBySearch(employee);
        return new Result(true, StatusCode.OK, "查询完成", employeeServiceByCondition);
    }

    @PostMapping("/findByList")
    public Result findByList(@RequestBody List<Integer> list) {
        List<Employee> employeeList = employeeService.findByList(list);
        return new Result(true, StatusCode.OK, "查询成功", employeeList);
    }

    @PostMapping("/findByMap")
    public Result findByMap(@RequestBody Map<String, Object> map) {
        List<Employee> employees = employeeService.findByMap(map);
        return new Result(true, StatusCode.OK, "查询成功", employees);
    }

    @GetMapping("/findPage/{page}/{size}")
    public Result findPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        List<Employee> employeePage = employeeService.findPage(page, size);
        //employeePage.stream().forEach(System.out::println);
        return new Result(true, StatusCode.OK, "查询成功", employeePage);
    }

    @PutMapping("updateById/{id}")
    public Result updateById(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.updateById(employee);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
