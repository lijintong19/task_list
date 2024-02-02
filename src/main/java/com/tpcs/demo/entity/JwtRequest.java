package com.tpcs.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}
