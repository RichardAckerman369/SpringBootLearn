package com.clown.mp.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Richard
 * @date: 2020/5/17
 **/
@Data
@TableName("tb_employee")
public class Employee extends Model<Employee> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "last_name", exist = true)
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    /**
     * 主键值 AR查询使用
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
