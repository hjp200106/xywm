package com.hjp.xywm.dto;


import com.hjp.xywm.entity.OrderDetail;
import com.hjp.xywm.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;
    //数量
    private int sumNum;

    private List<OrderDetail> orderDetails;
	
}
