package com.tpcs.demo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 通用前端相应类
 */
@Data
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;
    private String token;

    public JwtResponse(Integer code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }
}