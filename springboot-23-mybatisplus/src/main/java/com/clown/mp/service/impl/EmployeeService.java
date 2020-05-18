package com.clown.mp.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.clown.mp.mapper.EmployeeMapper;
import com.clown.mp.model.Employee;
import com.clown.mp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Richard
 * @date: 2020/5/17
 **/
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.selectList(null);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public List<Employee> findByList(List<Integer> list) {
        return employeeMapper.selectBatchIds(list);
    }

    @Override
    public Employee findBySearch(Employee employee) {
        return employeeMapper.selectOne(employee);
    }

    @Override
    public List<Employee> findPage(Integer page, Integer size) {
        return employeeMapper.selectPage(new Page<>(page, size), null);
    }

    @Override
    public List<Employee> findByMap(Map<String, Object> map) {
        return employeeMapper.selectByMap(map);
    }

    @Override
    public Integer add(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public Integer updateById(Employee employee) {
        return employeeMapper.updateById(employee);
    }

    @Override
    public Integer deleteById(Integer id) {
        return employeeMapper.deleteById(id);
    }

}
