package com.hjp.xywm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjp.xywm.entity.Orders;

public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);
}
