package com.hjp.xywm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjp.xywm.entity.OrderDetail;
import com.hjp.xywm.mapper.OrderDetailMapper;
import com.hjp.xywm.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>implements OrderDetailService {
}
