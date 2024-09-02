package com.tpcs.issue.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @Value("${file.path}")
    private String uploadPath;

    @RequestMapping("/getIssueRecords")
    public String getIssueRecords(Model model) {
        List<IssueRecordTable> issueRecords = issueRecordService.getAll();
        log.info("issueRecords" + issueRecords);
        model.addAttribute("issueRecords", issueRecords);
        return "records";
    }

    @RequestMapping("/index")
    public String getIndex() {
        return "index";
    }

    /**
     * testBootStrap
     */
    @RequestMapping("/login")
    public String testBootStrap() {
        return "login";
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
    public String addIssue(@ModelAttribute("issueRecords") IssueRecordTable issueRecord,
            @RequestParam("uploadFiles") MultipartFile[] files) {
        log.info("提交数据对象: {}", issueRecord);

        List<String> uploadFilesPath = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String datePath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Path dirPath = Paths.get(uploadPath, datePath);
                try {
                    if (!Files.exists(dirPath)) {
                        Files.createDirectories(dirPath);
                    }
                    Path filePath = dirPath.resolve(fileName);
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    uploadFilesPath.add(filePath.toString().replace("\\", "/"));
                } catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }
        }
        issueRecord.setUploadFilesPath(String.join(",", uploadFilesPath));
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
        issueRecord.setUpdateTime(new Date());
        int update = issueRecordService.update(issueRecord);
        System.out.println("update result:" + update);
        redirectAttributes.addFlashAttribute("message", "Issue record updated successfully!");
        return "redirect:/api/getIssueRecords";
    }

    /**
     * 详情方法
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String showIssueDetails(@RequestParam("id") Integer id, Model model) {
        IssueRecordTable issueRecord = issueRecordService.getById(id);
        model.addAttribute("issueRecord", issueRecord);
        return "detail";
    }

    /**
     * 查询方法
     */
    @RequestMapping("/search")
    public String showIssueRecordsBySearch(
            @RequestParam(value = "reporter", required = false) String reporter,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "status", required = false) String status,
            Model model) {

        List<IssueRecordTable> searchIssueRecords = issueRecordService.searchIssueRecords(reporter, date, status);
        log.info("searchIssueRecords" + searchIssueRecords);
        model.addAttribute("issueRecords", searchIssueRecords);
        return "records";
    }

}
