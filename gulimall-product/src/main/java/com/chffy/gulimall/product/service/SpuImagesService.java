package com.chffy.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chffy.common.utils.PageUtils;
import com.chffy.gulimall.product.entity.SpuImagesEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 20:03:38
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveImages(Long id, List<String> images);
}

