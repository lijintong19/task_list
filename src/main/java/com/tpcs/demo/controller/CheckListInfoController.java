package com.tpcs.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tpcs.demo.entity.CheckListInfo;
import com.tpcs.demo.entity.JwtResponse;
import com.tpcs.demo.entity.ListDetailOperateInfo;
import com.tpcs.demo.entity.ListTotalOperateInfo;
import com.tpcs.demo.mapper.CheckListInfoMapper;
import com.tpcs.demo.mapper.ListDetailOperateInfoMapper;
import com.tpcs.demo.mapper.ListTotalOperateInfoMapper;

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

    @Autowired
    ListDetailOperateInfoMapper listDetailOperateInfoMapper;

    @Autowired
    ListTotalOperateInfoMapper listTotalOperateInfoMapper;

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

    /**
     * 下拉框参数信息
     * 
     * @param customerName
     * @param fabName
     * @return
     */
    @GetMapping("/getInfoByName")
    public List<CheckListInfo> selectListInfoByCustomerName(String customerName, String fabName) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("customer_name", customerName);
        map.put("fab_name", fabName);
        List<CheckListInfo> selectByMap = checkListInfoMapper.selectByMap(map);
        log.info("根据客户名及厂房名搜索checklist:" + selectByMap);
        return selectByMap;
    }

    /**
     * 保存具体的操作
     * 
     * @param requestBody
     * @return
     */
    @PostMapping("/saveInfos")
    public JwtResponse saveOperateInfo(@RequestBody String requestBody) {
        log.info("接收到的操作信息为:" + requestBody);
        JSONObject detailInfo = JSONObject.parseObject(requestBody);
        JSONObject operatorInfo = detailInfo.getJSONObject("params");
        ListDetailOperateInfo listDetailOperateInfo = new ListDetailOperateInfo();
        listDetailOperateInfo.setCustomerName(operatorInfo.getString("customerName"));
        listDetailOperateInfo.setFabName(operatorInfo.getString("fabName"));
        listDetailOperateInfo.setDeviceNumber(operatorInfo.getString("deviceNumber"));
        listDetailOperateInfo.setLayerNumber(operatorInfo.getString("layerNumber"));
        listDetailOperateInfo.setOperatorName(operatorInfo.getString("operatorName"));
        listDetailOperateInfo.setOrderNumber(operatorInfo.getString("orderNumber"));
        listDetailOperateInfo.setTechnology(operatorInfo.getString("technology"));
        listDetailOperateInfo.setStep(operatorInfo.getString("step"));
        listDetailOperateInfo.setStatus(operatorInfo.getString("status").equals("true") ? "finished" : "unfinished");
        listDetailOperateInfo.setCreateTime(new Date());
        listDetailOperateInfoMapper.insert(listDetailOperateInfo);
        return new JwtResponse(00, "Success", "");
    }

    /**
     * 更新详情表中的步骤状态
     */
    @PostMapping("/updateInfos")
    public JwtResponse updateListOperateInfo(@RequestBody String requestBody) {
        log.info("修改操作信息为:" + requestBody);
        Map<String, Object> map = new HashMap<>();
        JSONObject detailInfo = JSONObject.parseObject(requestBody);
        JSONObject operatorInfo = detailInfo.getJSONObject("params");
        // 查询参数
        map.put("status", operatorInfo.getString("status").equals("true") ? "finished" : "unfinished");
        map.put("customerName", operatorInfo.getString("customerName"));
        map.put("operatorName", operatorInfo.getString("operatorName"));
        map.put("fabName", operatorInfo.getString("fabName"));
        map.put("step", operatorInfo.getString("step"));
        map.put("orderNumber", operatorInfo.getString("orderNumber"));
        int result = listDetailOperateInfoMapper.updateInfoByConditions(map);
        log.info("更新操作表结果为:" + result);
        if (result != 0) {
            return new JwtResponse(00, "Success", "");
        } else {
            return new JwtResponse(01, "Failed", "");
        }
    }

    /**
     * 根据指定条件查找方法
     * 
     * @param requestBody
     * @return
     */
    @PostMapping("/selectInfos")
    public JwtResponse selectDetailOperationInfo(@RequestBody String requestBody) {
        log.info("查找特定条件操作信息的参数:" + requestBody);
        JSONObject totalInfo = JSONObject.parseObject(requestBody);
        JSONObject operatorInfo = totalInfo.getJSONObject("params");
        Map<String, Object> map = new HashMap<>();
        // 查询条件
        map.put("customerName", operatorInfo.getString("customerName"));
        map.put("operatorName", operatorInfo.getString("operatorName"));
        map.put("fabName", operatorInfo.getString("fabName"));
        map.put("step", operatorInfo.getString("step"));
        map.put("orderNumber", operatorInfo.getString("orderNumber"));
        ListDetailOperateInfo selectInfoByConditions = listDetailOperateInfoMapper.selectInfoByConditions(map);
        if (null != selectInfoByConditions) {
            return new JwtResponse(00, "Success", "");
        } else {
            return new JwtResponse(01, "Failed", "");
        }
    }

    /**
     * 保存具体的操作信息
     * 
     * @param requestBody
     * @return
     */
    @PostMapping("/saveTotalInfos")
    public JwtResponse saveTotalOperateInfo(@RequestBody String requestBody) {
        log.info("勾选全部完成后的信息为:" + requestBody);
        JSONObject totalInfo = JSONObject.parseObject(requestBody);
        JSONObject operatorInfo = totalInfo.getJSONObject("params");
        ListTotalOperateInfo listTotalInfo = new ListTotalOperateInfo();
        listTotalInfo.setCustomerName(operatorInfo.getString("customerName"));
        listTotalInfo.setOperatorName(operatorInfo.getString("operatorName"));
        listTotalInfo.setOrderNumber(operatorInfo.getString("orderNumber"));
        listTotalInfo.setSpentTime(operatorInfo.getString("spentTime"));
        listTotalInfo.setStatus(operatorInfo.getString("status").equals("true") ? "完成" : "未完成");
        listTotalInfo.setCreateTime(new Date());
        listTotalOperateInfoMapper.insert(listTotalInfo);
        return new JwtResponse(00, "Success", "");
    }

    /**
     * 更新具体操作信息
     * 
     * @param requestBody
     * @return
     */
    @PostMapping("/updateTotalInfos")
    public JwtResponse updateTotalOperateInfo(@RequestBody String requestBody) {
        log.info("更新具体操作信息表请求参数:" + requestBody);
        
        return new JwtResponse(00, "Success", "");
    }

    /**
     * 获取用户的订单信息
     * 
     * @param customerName
     * @return
     */
    @GetMapping("/getDetailInfo")
    public List<ListDetailOperateInfo> getListDetailInfoByName(@RequestParam String operatorName) {
        log.info("用户姓名为:" + operatorName);
        List<ListDetailOperateInfo> selectDetailInfoByName = listDetailOperateInfoMapper
                .selectDetailInfoByName(operatorName);
        log.info("该用户" + operatorName + "的订单信息为:" + selectDetailInfoByName);
        return selectDetailInfoByName;
    }

    /**
     * 获取用户的汇总订单信息
     * 
     * @param operatorName
     * @return
     */
    @GetMapping("/getTotalInfo")
    public List<ListTotalOperateInfo> getTotalInfoByName(@RequestParam String operatorName) {
        log.info("前端参数为:" + operatorName);
        List<ListTotalOperateInfo> totalInfoByName = listTotalOperateInfoMapper.getTotalInfoByName(operatorName);
        log.info("该用户" + operatorName + "的订单信息为:" + totalInfoByName);
        return totalInfoByName;
    }

    public void getImage() {

    }
}
