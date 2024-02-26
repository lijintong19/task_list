package com.tpcs.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tpcs.demo.entity.CustomerInfo;
import com.tpcs.demo.entity.FabInfo;
import com.tpcs.demo.entity.JwtResponse;
import com.tpcs.demo.entity.TechInfo;
import com.tpcs.demo.mapper.CustomerInfoMapper;
import com.tpcs.demo.mapper.FabInfoMapper;
import com.tpcs.demo.mapper.TechInfoMapper;
import com.tpcs.demo.service.CustomerInfoService;

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
    private CustomerInfoMapper customerInfoMapper;

    @Autowired
    private FabInfoMapper fabInfoMapper;

    @Autowired
    private TechInfoMapper techInfoMapper;

    @Autowired
    private CustomerInfoService customerInfoService;

    /**
     * 获取所有客户信息
     * 
     * @return
     */
    @GetMapping("/getInfo")
    public List<CustomerInfo> getCustomerInfo() {
        List<CustomerInfo> customerInfos = customerInfoMapper.selectAll();
        log.info("客户表信息:" + customerInfos);
        return customerInfos;
    }

    /**
     * 获取和客户对应的厂房信息
     * 
     * @param customerName
     * @return
     */
    @GetMapping("/getFabInfo")
    public List<FabInfo> getFabName(@RequestParam String customerName) {
        log.info("客户姓名:" + customerName);
        List<FabInfo> selectFabNameList = fabInfoMapper.selectFabNameList(customerName);
        log.info("厂房信息:" + selectFabNameList);
        return selectFabNameList;
    }

    /**
     * 获取技术节点信息
     * 
     * @return
     */
    @GetMapping("/getTechInfo")
    public List<TechInfo> getTechInfos() {
        List<TechInfo> selectAllInfos = techInfoMapper.selectAllInfos();
        return selectAllInfos;
    }

    /**
     * 查找客户分类
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public Page<CustomerInfo> getCustomerPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<CustomerInfo> selectPage = customerInfoService.selectPage(pageNum, pageSize);
        log.info("客户分类:" + selectPage);
        return selectPage;
    }

    /**
     * 删除客户
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public JwtResponse deleteCustomer(@RequestParam Integer id) {
        log.info("客户信息为:" + id);
        int deleteById = customerInfoMapper.deleteById(id);
        log.info("删除客户信息结果:" + deleteById);
        return new JwtResponse(00, "Success", "");
    }

    @PostMapping("/add")
    public JwtResponse addCustomer(@RequestBody String customerName) {
        log.info("客户名称为:" + customerName);
        JSONObject json = JSONObject.parseObject(customerName);
        JSONObject params = json.getJSONObject("params");
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setCustomerName(params.getString("customerName"));
        customerInfo.setCreateTime(new Date());
        int insert = customerInfoMapper.insert(customerInfo);
        log.info("添加客户信息结果:" + insert);
        return new JwtResponse(0, "Success", "");
    }
}
