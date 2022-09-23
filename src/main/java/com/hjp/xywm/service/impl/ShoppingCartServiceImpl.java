package com.hjp.xywm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjp.xywm.entity.ShoppingCart;
import com.hjp.xywm.mapper.ShoppingCatMapper;
import com.hjp.xywm.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCatMapper, ShoppingCart>implements ShoppingCartService {
}
