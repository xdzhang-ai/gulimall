package com.chffy.gulimall.product.service.impl;

import com.chffy.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chffy.common.utils.PageUtils;
import com.chffy.common.utils.Query;

import com.chffy.gulimall.product.dao.CategoryDao;
import com.chffy.gulimall.product.entity.CategoryEntity;
import com.chffy.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> path = new ArrayList<>();
        findParentPath(catelogId, path);

        Collections.reverse(path);
        return path.toArray(new Long[0]);
    }

    private void findParentPath(Long catelogId, List<Long> path) {
        path.add(catelogId);
        CategoryEntity category = this.getById(catelogId);
        if (category.getParentCid() != 0) {
            findParentPath(category.getParentCid(), path);
        }
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryEntity> level1 = entities.stream().filter(
                categoryEntity -> categoryEntity.getParentCid() == 0
        ).map(menu -> {
            menu.setChildren(getChidrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0: menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());        }).collect(Collectors.toList());
        return level1;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 检查当前删除的菜单
        baseMapper.deleteBatchIds(asList);
    }

    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());

    }

    private List<CategoryEntity> getChidrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> level = all.stream().filter(
                categoryEntity -> categoryEntity.getParentCid() == root.getCatId()
        ).map(menu -> {
            menu.setChildren(getChidrens(menu, all));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0: menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return level;
    }

}