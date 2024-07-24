package com.tpcs.issue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpcs.issue.entity.IssueRecordTable;
import com.tpcs.issue.mapper.IssueRecordMapper;

/**
 * @author lijt
 * @date 2024/06/07
 */
@Service
public class IssueRecordService {

    @Autowired
    private IssueRecordMapper issueRecordMapper;

    /**
     * select all
     * 
     * @return
     */
    public List<IssueRecordTable> getAll() {
        return issueRecordMapper.selectAll();
    }

    /**
     * insert issue record
     * 
     * @param issueRecord
     * @return
     */
    public int insert(IssueRecordTable issueRecord) {
        return issueRecordMapper.insert(issueRecord);
    }

    /**
     * delete issue record by id
     * 
     * @param id
     * @return
     */
    public int delete(int id) {
        return issueRecordMapper.deleteById(id);
    }

    /**
     * update issue record
     * 
     * @param id
     * @return
     */
    public IssueRecordTable getById(int id) {
        return issueRecordMapper.selectById(id);
    }

    /**
     * update issue record
     * 
     * @param issueRecord
     * @return
     */
    public int update(IssueRecordTable issueRecord) {
        return issueRecordMapper.updateById(issueRecord);
    }

    /**
     * select by status
     * 
     * @return
     */
    public List<IssueRecordTable> getListByStatus() {
       return issueRecordMapper.selectByStatus();
    }
}
