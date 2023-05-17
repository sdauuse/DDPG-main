package com.miao.order.pojo;

import com.miao.user.pojo.User;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;

    //封装用户信息
    private User user;
}