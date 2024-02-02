package com.tpcs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpcs.demo.entity.CustomerInfo;
import com.tpcs.demo.entity.FabInfo;
import com.tpcs.demo.entity.TechInfo;
import com.tpcs.demo.mapper.CustomerInfoMapper;
import com.tpcs.demo.mapper.FabInfoMapper;
import com.tpcs.demo.mapper.TechInfoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 客户信息表 前端控制器
 * </p>
 *
 * @author lijt
 * @since 2024-01-22
 */
@Slf4j
@RestController
@RequestMapping("/customerInfo")
public class CustomerInfoController {

    @Autowired
    CustomerInfoMapper customerInfoMapper;

    @Autowired
    FabInfoMapper fabInfoMapper;

    @Autowired
    TechInfoMapper techInfoMapper;

    @GetMapping("/getInfo")
    public List<CustomerInfo> getCustomerInfo() {
        List<CustomerInfo> customerInfos = customerInfoMapper.selectAll();
        log.info("客户表信息:" + customerInfos);
        return customerInfos;
    }

    @GetMapping("/getFabInfo")
    public List<FabInfo> getFabName(@RequestParam String customerName) {
        log.info("客户姓名:" + customerName);
        List<FabInfo> selectFabNameList = fabInfoMapper.selectFabNameList(customerName);
        log.info("厂房信息:" + selectFabNameList);
        return selectFabNameList;
    }

    @GetMapping("/getTechInfo")
    public List<TechInfo> getTechInfos() {
        List<TechInfo> selectAllInfos = techInfoMapper.selectAllInfos();
        return selectAllInfos;
    }

}
