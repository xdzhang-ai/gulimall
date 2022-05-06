package com.chffy.gulimall.coupon.dao;

import com.chffy.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 22:43:01
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
