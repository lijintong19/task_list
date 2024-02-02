package com.tpcs.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tpcs.demo.entity.User;

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
