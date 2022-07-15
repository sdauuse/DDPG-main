package com.miao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.entity.Dish;
import com.miao.mapper.DishMapper;
import com.miao.service.DishService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper,Dish> implements DishService {
}
