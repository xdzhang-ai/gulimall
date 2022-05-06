package com.chffy.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chffy.common.to.SkuReductionTo;
import com.chffy.common.utils.PageUtils;
import com.chffy.gulimall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 22:43:01
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo reductionTo);
}

