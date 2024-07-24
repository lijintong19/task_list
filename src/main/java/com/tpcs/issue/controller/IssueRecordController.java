package com.tpcs.issue.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tpcs.issue.entity.IssueRecordTable;
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
        List<IssueRecordTable> issueRecords = issueRecordService.getAll();
        log.info("issueRecords" + issueRecords);
        model.addAttribute("issueRecords", issueRecords);
        return "issueRecordsView";
    }

    @RequestMapping("/index")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/add")
    public String showAddIssueForm(Model model) {
        // 创建一个新的IssueRecord对象，并将其添加到Model中
        IssueRecordTable issueRecord = new IssueRecordTable();
        model.addAttribute("issueRecords", issueRecord);
        return "add";
    }

    /**
     * 添加方法
     * 
     * @param issueRecord
     * @return
     */
    @PostMapping("/addIssue")
    public String addIssue(@ModelAttribute("issueRecords") IssueRecordTable issueRecord) {
        log.info("提交数据对象:{}", issueRecord);
        // 处理表单数据，例如保存到数据库
        issueRecord.setCreateTime(new Date());
        issueRecordService.insert(issueRecord);
        return "redirect:/api/getIssueRecords";
    }

    /**
     * 删除方法
     * 
     * @param id
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/delete")
    public String deleteIssueRecord(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        issueRecordService.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/api/getIssueRecords";
    }

    /**
     * 编辑方法
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String showEditForm(@RequestParam("id") Integer id, Model model) {
        IssueRecordTable issueRecord = issueRecordService.getById(id);
        model.addAttribute("issueRecords", issueRecord);
        return "edit";
    }

    /**
     * 更新方法
     * 
     * @param issueRecord
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/update")
    public String updateIssueRecord(@ModelAttribute("issueRecords") IssueRecordTable issueRecord,
            RedirectAttributes redirectAttributes) {
        issueRecordService.update(issueRecord);
        redirectAttributes.addFlashAttribute("message", "Issue record updated successfully!");
        return "redirect:/api/getIssueRecords";
    }
}
