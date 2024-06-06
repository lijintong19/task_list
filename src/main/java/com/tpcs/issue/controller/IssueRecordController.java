package com.tpcs.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpcs.issue.entity.IssueRecord;
import com.tpcs.issue.mapper.IssueRecordMapper;

@RestController
@RequestMapping("/api")
public class IssueRecordController {

    @Autowired
    IssueRecordMapper issueRecordMapper;
    
    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World!";
    }

    @GetMapping("/getInfo")
    public List<IssueRecord> getIssueRecords() {
        List<IssueRecord> issueRecords = issueRecordMapper.selectAll();
        return issueRecords;
    }
}
