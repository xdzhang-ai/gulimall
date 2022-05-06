package com.chffy.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chffy.common.utils.PageUtils;
import com.chffy.gulimall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 23:11:10
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

