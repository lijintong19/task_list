package com.tpcs.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tpcs.issue.entity.IssueRecord;
import com.tpcs.issue.service.IssueRecordService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijt
 * @date 2024/06/07
 */
@Controller
@RequestMapping("/api")
@Slf4j
public class IssueRecordController {

    @Autowired
    IssueRecordService issueRecordService;

    @RequestMapping("/getIssueRecords")
    public String getIssueRecords(Model model) {
        List<IssueRecord> issueRecords = issueRecordService.getAll();
        log.info("issueRecords" + issueRecords);
        model.addAttribute("issueRecords", issueRecords);
        return "issueRecordsView";
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/add")
    public String addIssueRecord(){
        return "add";
    }
}
