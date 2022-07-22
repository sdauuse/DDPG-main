package com.miao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.entity.OrderDetail;
import com.miao.mapper.OrderDetailMapper;
import com.miao.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}