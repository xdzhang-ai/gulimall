package com.chffy.gulimall.order.dao;

import com.chffy.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 23:19:24
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
