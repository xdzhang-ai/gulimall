package com.chffy.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chffy.common.utils.PageUtils;
import com.chffy.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author chffy
 * @email chffy97@163.com
 * @date 2022-02-23 22:55:35
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

