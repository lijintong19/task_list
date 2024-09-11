package com.tpcs.issue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tpcs.issue.entity.HighTechnologyRecordTable;
import com.tpcs.issue.mapper.HighTechnologyRecordMapper;

@Service
public class HighTechnologyRecordService {
    
    @Autowired
    private HighTechnologyRecordMapper highTechnologyRecordMapper;

    /**
     * select all
     * 
     * @return
     */
    public List<HighTechnologyRecordTable> getAll() {
        return highTechnologyRecordMapper.selectAll();
    }

    /**
     * insert issue record
     * 
     * @param highTech
     * @return
     */
    public int insert(HighTechnologyRecordTable highTech) {
        return highTechnologyRecordMapper.insert(highTech);
    }

    /**
     * get highTechById
     * 
     * @param id
     * @return
     */
    public HighTechnologyRecordTable getById(int id) {
        return highTechnologyRecordMapper.selectById(id);
    }

    /**
     * delete record by id
     * 
     * @param id
     * @return
     */
    public int delete(int id) {
        return highTechnologyRecordMapper.deleteById(id);
    }

    /**
     * update issue record
     * 
     * @param issueRecord
     * @return
     */
    public int update(HighTechnologyRecordTable highTechTable) {
        return highTechnologyRecordMapper.updateById(highTechTable);
    }

    /**
     * search issue records
     * 
     * @param customer
     * @param device
     * @param orderNum
     * @param layer
     * @return
     */
    public List<HighTechnologyRecordTable> searchIssueRecords(String customer, String device, String orderNum, String layer,String opr) {
        QueryWrapper<HighTechnologyRecordTable> queryWrapper = new QueryWrapper<>();

        if (customer != null && !customer.isEmpty()) {
            queryWrapper.eq("customer", customer);
        }
        if (device != null && !device.isEmpty()) {
            queryWrapper.eq("device", device);
        }
        if (orderNum != null && !orderNum.isEmpty()) {
            queryWrapper.eq("order_num", orderNum);
        }
        if (layer != null && !layer.isEmpty()) {
            queryWrapper.eq("layer", layer);
        }
        if (opr != null && !opr.isEmpty()) {
            queryWrapper.eq("opr", opr);
        }

        return highTechnologyRecordMapper.selectList(queryWrapper);
    }    
    
}
