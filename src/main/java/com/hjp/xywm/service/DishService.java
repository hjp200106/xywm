package com.hjp.xywm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjp.xywm.dto.DishDto;
import com.hjp.xywm.entity.Dish;

public interface DishService extends IService<Dish> {
    //保存菜品和口味 多表联合
    public void saveWithFlavor(DishDto dishDto);
    //查询菜品和口味信息
    public DishDto getByIdWithFlavor(Long id);
    //更新菜品和口味信息
    public void updateWithFlavor(DishDto dishDto);
}
