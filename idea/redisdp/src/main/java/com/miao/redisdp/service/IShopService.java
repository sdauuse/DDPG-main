package com.miao.redisdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.redisdp.dto.Result;
import com.miao.redisdp.entity.Shop;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IShopService extends IService<Shop> {

    Result queryById(Long id);

    Result update(Shop shop);
}
