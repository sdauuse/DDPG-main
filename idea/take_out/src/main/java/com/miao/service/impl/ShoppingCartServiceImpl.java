package com.miao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.entity.ShoppingCart;
import com.miao.mapper.ShoppingCartMapper;
import com.miao.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
