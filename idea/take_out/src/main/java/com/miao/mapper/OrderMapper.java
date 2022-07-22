package com.miao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}