package com.miao.infrastructure.dao;

import com.miao.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {
    Strategy queryStrategy(Long strategyId);
}
