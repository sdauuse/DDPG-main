package com.miao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
