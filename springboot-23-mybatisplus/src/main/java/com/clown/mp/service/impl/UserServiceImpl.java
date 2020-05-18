package com.clown.mp.service.impl;

import com.clown.mp.model.User;
import com.clown.mp.mapper.UserMapper;
import com.clown.mp.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Richard
 * @since 2020-05-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    //不用在进行mapper注入,在ServiceImpl<UserMapper, User>就已经帮我们注入了
    //并且其中就已经存在一些常用方法
}
