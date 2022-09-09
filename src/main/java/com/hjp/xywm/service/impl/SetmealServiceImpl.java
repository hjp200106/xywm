package com.hjp.xywm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjp.xywm.entity.Setmeal;
import com.hjp.xywm.mapper.SetmealMapper;
import com.hjp.xywm.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService{
}
