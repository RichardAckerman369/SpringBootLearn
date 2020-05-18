package com.clown.mp.service;

import com.clown.mp.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author: Richard
 * @date: 2020/5/17
 **/
public interface IEmployeeService {

    List<Employee> findAll();

    Employee findById(Integer id);

    List<Employee> findByList(List<Integer> list);

    Employee findBySearch(Employee employee);

    List<Employee> findPage(Integer page,Integer size);

    List<Employee> findByMap(Map<String,Object> map);

    Integer add(Employee employee);

    Integer updateById(Employee employee);

    Integer deleteById(Integer id);

}
