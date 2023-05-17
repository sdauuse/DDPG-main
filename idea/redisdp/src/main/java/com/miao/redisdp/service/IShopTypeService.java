package com.miao.redisdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.redisdp.dto.Result;
import com.miao.redisdp.entity.ShopType;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IShopTypeService extends IService<ShopType> {

    Result queryTypeList();
}
