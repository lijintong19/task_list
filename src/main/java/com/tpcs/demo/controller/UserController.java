package com.tpcs.demo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpcs.demo.model.User;
import com.tpcs.demo.service.UserService;

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
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody String request) {
        log.info("前端请求信息为:" + request);
        return "登录成功";
    }
}
