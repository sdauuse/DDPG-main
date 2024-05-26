package com.miao.strategy.service.draw;

import com.miao.infrastructure.po.Award;
import com.miao.strategy.model.aggregates.StrategyRich;
import com.miao.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-17
 * @Copyright：
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    private IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected Award queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }

}
