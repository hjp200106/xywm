package com.hjp.xywm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjp.xywm.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.Base64;

@Mapper
public interface ShoppingCatMapper extends BaseMapper<ShoppingCart> {
}
