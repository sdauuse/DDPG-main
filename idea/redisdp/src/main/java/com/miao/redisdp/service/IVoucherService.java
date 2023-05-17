package com.miao.redisdp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.redisdp.dto.Result;
import com.miao.redisdp.entity.Voucher;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IVoucherService extends IService<Voucher> {

    Result queryVoucherOfShop(Long shopId);

    void addSeckillVoucher(Voucher voucher);
}
