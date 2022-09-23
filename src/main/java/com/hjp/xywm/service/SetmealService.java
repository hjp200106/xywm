package com.hjp.xywm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjp.xywm.dto.DishDto;
import com.hjp.xywm.dto.SetmealDto;
import com.hjp.xywm.entity.Setmeal;

public interface SetmealService extends IService<Setmeal> {
     public void saveWithDish(SetmealDto setmealDto);
     public SetmealDto getByIdWithDish(Long id);
     //更新套餐和菜品信息
     public void updateWithDish(SetmealDto setmealDto);
}
