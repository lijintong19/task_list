package com.tpcs.issue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpcs.issue.entity.IssueRecord;
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
    public List<IssueRecord> getAll() {
        return issueRecordMapper.selectAll();
    }
}
