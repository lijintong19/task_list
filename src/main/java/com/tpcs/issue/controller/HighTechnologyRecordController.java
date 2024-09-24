package com.tpcs.issue.controller;

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

import com.tpcs.issue.entity.HighTechnologyRecordTable;
import com.tpcs.issue.service.HighTechnologyRecordService;
import com.tpcs.issue.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/highTech")
@Slf4j
public class HighTechnologyRecordController {

    @Autowired
    HighTechnologyRecordService highTechnologyRecordService;

    /**
     * 获取全部列表方法
     * 
     * @param model
     * @return
     */
    @RequestMapping("/getRecords")
    public String getIssueRecords(Model model) {
        List<HighTechnologyRecordTable> highTechRecords = highTechnologyRecordService.getAll();
        model.addAttribute("highTechRecords", highTechRecords);
        return "highTech";
    }

    /**
     * 新增方法
     * 
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String showAddIssueForm(Model model) {
        // 创建一个新的IssueRecord对象，并将其添加到Model中
        HighTechnologyRecordTable highTechnologyRecordTable = new HighTechnologyRecordTable();
        model.addAttribute("highTechRecords", highTechnologyRecordTable);
        return "highTechAdd";
    }

    /**
     * 上传文件方法
     * 
     * @param issueRecord
     * @return
     */
    @PostMapping("/addHighTech")
    public String addIssue(@ModelAttribute("highTechRecords") HighTechnologyRecordTable highTech) {
        log.info("提交数据对象: {}", highTech);
        if (highTech.getJobdeckCheckTime().isEmpty()
                || highTech.getMfCheck().isEmpty() || highTech.getCdCheck().isEmpty()
                || highTech.getMpc().isEmpty()
                || highTech.getGraphicsCheck().isEmpty()
                || highTech.getDdCheck().isEmpty()
                || highTech.getImaskRt().isEmpty()
                || highTech.getSpecialSizing().isEmpty()
                || highTech.getXppa().isEmpty()) {
                    highTech.setRemind("N");
        } else {
            highTech.setRemind("Y");
        }
        highTech.setCreateTime(DateUtils.getDatePlus12Hours());
        highTechnologyRecordService.insert(highTech);
        return "redirect:/highTech/getRecords";
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
        HighTechnologyRecordTable highTechRecords = highTechnologyRecordService.getById(id);
        model.addAttribute("highTechRecords", highTechRecords);
        return "highTechDetail";
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
        highTechnologyRecordService.delete(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/highTech/getRecords";
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
        HighTechnologyRecordTable highTechTable = highTechnologyRecordService.getById(id);
        model.addAttribute("highTechRecords", highTechTable);
        return "highTechEdit";
    }

    /**
     * 更新方法
     * 
     * @param issueRecord
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/update")
    public String updateIssueRecord(@ModelAttribute("highTechRecords") HighTechnologyRecordTable highTechTable,
            RedirectAttributes redirectAttributes) {
        if (highTechTable.getJobdeckCheckTime().isEmpty()
                || highTechTable.getMfCheck().isEmpty() || highTechTable.getCdCheck().isEmpty()
                || highTechTable.getMpc().isEmpty()
                || highTechTable.getGraphicsCheck().isEmpty() || highTechTable.getDdCheck().isEmpty()
                || highTechTable.getImaskRt().isEmpty()
                || highTechTable.getSpecialSizing().isEmpty() || highTechTable.getXppa().isEmpty()) {
            highTechTable.setRemind("N");
        } else {
            highTechTable.setRemind("Y");
        }
        highTechTable.setUpdateTime(DateUtils.getDatePlus12Hours());
        int update = highTechnologyRecordService.update(highTechTable);
        System.out.println("update result:" + update);
        redirectAttributes.addFlashAttribute("message", "High Tech record updated successfully!");
        return "redirect:/highTech/getRecords";
    }

    /**
     * 查询方法
     */
    @RequestMapping("/search")
    public String showIssueRecordsBySearch(
            @RequestParam(value = "customer", required = false) String customer,
            @RequestParam(value = "device", required = false) String device,
            @RequestParam(value = "orderNum", required = false) String orderNum,
            @RequestParam(value = "layer", required = false) String layer,
            @RequestParam(value = "opr", required = false) String opr,
            Model model) {

        List<HighTechnologyRecordTable> searchIssueRecords = highTechnologyRecordService.searchIssueRecords(customer,
                device, orderNum, layer, opr);
        log.info("searchIssueRecords" + searchIssueRecords);
        model.addAttribute("highTechRecords", searchIssueRecords);
        return "highTech";
    }
}
