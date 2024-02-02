package com.tpcs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.tpcs.demo.entity.FabInfo;
import com.tpcs.demo.mapper.FabInfoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 厂房信息表 前端控制器
 * </p>
 *
 * @author lijt
 * @since 2024-01-23
 */
@Slf4j
@RestController
@RequestMapping("/fabInfo")
public class FabInfoController {

    @Autowired
    FabInfoMapper fabInfoMapper;

    @GetMapping("/getFabInfo")
    public List<FabInfo> getFabName() {
        List<FabInfo> selectFabNameList = fabInfoMapper.selectFabNameList("HUAWEI");
        log.info("厂房信息:" + selectFabNameList);
        return selectFabNameList;
    }

}
