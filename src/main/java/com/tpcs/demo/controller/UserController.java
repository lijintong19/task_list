package com.tpcs.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpcs.demo.entity.JwtRequest;
import com.tpcs.demo.entity.JwtResponse;
import com.tpcs.demo.entity.User;
import com.tpcs.demo.mapper.UserMapper;
import com.tpcs.demo.utils.JwtUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lky
 * @since 2023-12-14
 */
@RestController
@Slf4j
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest request) {
        log.info("前端请求信息为:" + request);
        Map<String, Object> map = new HashMap<>();
        map.put("name", request.getUsername());
        map.put("password", request.getPassword());
        List<User> selectByMap = userMapper.selectByMap(map);
        if (selectByMap.size() == 0) {
            return new JwtResponse(01, "Failed", "");
        }
        String token = jwtUtil.generateToken(request.getUsername());
        return new JwtResponse(00, "Success", token);
    }
}
