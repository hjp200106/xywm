package com.hjp.xywm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjp.xywm.entity.User;
import com.hjp.xywm.mapper.UserMapper;
import com.hjp.xywm.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
