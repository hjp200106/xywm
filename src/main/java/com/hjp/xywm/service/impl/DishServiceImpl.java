package com.hjp.xywm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjp.xywm.entity.Dish;
import com.hjp.xywm.mapper.DishMapper;
import com.hjp.xywm.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService{
}
