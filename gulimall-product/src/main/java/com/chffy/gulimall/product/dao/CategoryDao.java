package com.chffy.gulimall.product.dao;

import com.chffy.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 20:03:38
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
