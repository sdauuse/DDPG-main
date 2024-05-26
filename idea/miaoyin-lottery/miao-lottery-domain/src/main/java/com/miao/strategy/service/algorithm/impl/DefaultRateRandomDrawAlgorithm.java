package com.miao.strategy.service.algorithm.impl;

import com.miao.strategy.model.vo.AwardRateInfo;
import com.miao.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // 排除掉不在抽奖范围的奖品ID集合
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            // excludeAwardIds表示哪些奖品不在名单中
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            // 剩下的奖品有哪些
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        // 前置判断
        if (differenceAwardRateList.size() == 0) return "";
        if (differenceAwardRateList.size() == 1) return differenceAwardRateList.get(0).getAwardId();

        // 获取随机概率值
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;

        // 循环获取奖品
        String awardId = "";
        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            // 中奖概率为：奖品的score/总奖品的score， scale结果小数部分的位数
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }

        // 返回中奖结果
        return awardId;
    }

}
