package com.tpcs.demo.mapper;

import com.tpcs.demo.model.User;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lky
 * @since 2023-12-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
