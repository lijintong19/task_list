package com.tpcs.demo.service.impl;

import com.tpcs.demo.model.User;
import com.tpcs.demo.mapper.UserMapper;
import com.tpcs.demo.service.UserService;

import lombok.AllArgsConstructor;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lky
 * @since 2023-12-14
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
