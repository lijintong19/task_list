package com.tpcs.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.tpcs.demo.entity.CheckListInfo;
import com.tpcs.demo.mapper.CheckListInfoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * checkList步骤描述表 前端控制器
 * </p>
 *
 * @author lijt
 * @since 2024-01-09
 */
@Slf4j
@RestController
@RequestMapping("/checkList")
public class CheckListInfoController {

    @Autowired
    CheckListInfoMapper checkListInfoMapper;

    /**
     * 展示checkList步骤
     * 
     * @return
     */
    @RequestMapping("/showInfo")
    public List<CheckListInfo> showCheckListInfo() {
        List<CheckListInfo> selectAll = checkListInfoMapper.selectAll();
        log.info("check_list_info:" + selectAll);
        return selectAll;
    }

    @GetMapping("/getInfoByName")
    public List<CheckListInfo> selectListInfoByCustomerName(String customerName, String fabName) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_name", customerName);
        map.put("fab_name", fabName);
        List<CheckListInfo> selectByMap = checkListInfoMapper.selectByMap(map);
        log.info("根据客户名及厂房名搜索checklist:" + selectByMap);
        return selectByMap;
    }

}
