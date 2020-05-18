package com.clown.mp.controller;

import com.clown.mp.common.Result;
import com.clown.mp.common.StatusCode;
import com.clown.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Richard
 * @since 2020-05-18
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/selectList")
    public Result selectList() {
        return new Result(true, StatusCode.OK, "查询成功", userService.selectList(null));
    }
}

