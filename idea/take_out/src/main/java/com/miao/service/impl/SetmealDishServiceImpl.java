package com.miao.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.dto.SetmealDto;
import com.miao.entity.Setmeal;
import com.miao.entity.SetmealDish;
import com.miao.mapper.SetmealDishMapper;
import com.miao.mapper.SetmealMapper;
import com.miao.service.SetmealDishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {

}
