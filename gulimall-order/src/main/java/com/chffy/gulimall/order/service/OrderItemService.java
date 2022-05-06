package com.chffy.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chffy.common.utils.PageUtils;
import com.chffy.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 23:19:24
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

