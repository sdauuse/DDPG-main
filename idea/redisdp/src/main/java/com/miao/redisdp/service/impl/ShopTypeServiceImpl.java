package com.miao.redisdp.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.redisdp.dto.Result;
import com.miao.redisdp.entity.ShopType;
import com.miao.redisdp.mapper.ShopTypeMapper;
import com.miao.redisdp.service.IShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.miao.redisdp.utils.RedisConstants.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IShopTypeService typeService;

    /**
     * 该功能未完成
     * @return
     */
    @Override
    public Result queryTypeList() {

        String key = CACHE_SHOPTYPE_KEY;

        String cacheShop = stringRedisTemplate.opsForValue().get(key);


        if (StrUtil.isNotEmpty(cacheShop)) {

            //2: 有直接返回
            List<ShopType> shopTypes = Convert.toList(ShopType.class, cacheShop);
            return Result.ok(shopTypes);

        }

        //3：没有、去数据库中查询
        List<ShopType> typeList = typeService
                .query().orderByAsc("sort").list();

        if (CollUtil.isEmpty(typeList)) {
            //4：没有
            return Result.fail("没有商品类别");

        }
        //5：有、将店铺数据写入redis中
        stringRedisTemplate.opsForValue().set(key, Convert.toStr(typeList));

        //6：返回店铺列表数据
        return Result.ok(typeList);
    }
}
