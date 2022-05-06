package com.chffy.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chffy.common.utils.PageUtils;
import com.chffy.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 20:03:38
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity infoDescEntity);
}

