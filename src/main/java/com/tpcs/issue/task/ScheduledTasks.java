package com.tpcs.issue.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tpcs.issue.entity.IssueRecordTable;
import com.tpcs.issue.service.IssueRecordService;

@Service
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private IssueRecordService issueRecordService;

    @Autowired
    private JavaMailSender javaMailSender;

    // @Scheduled(cron = "0 */4 * * * ?")
    public void sendEmail() {
        List<IssueRecordTable> data = issueRecordService.getListByStatus();
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Hi All,\n\n");
        emailBody.append("Below is the daily issue report for today:\n\n");

        if (!data.isEmpty()) {
            emailBody.append("On going issues:\n");
            for (IssueRecordTable record : data) {
                if ("On going".equals(record.getIssueStatus())) {
                    emailBody.append("-ID: ").append(record.getId()).append("-issueDescription: ")
                            .append(record.getIssueDescription()).append("\n");
                } else {
                    emailBody.append("There is no on going issue.\n");
                }
            }
        } else {
            emailBody.append("There is no issue record for today.\n");
        }
        
        emailBody.append("\nBest regards,\nAuto");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@tpcs.com");
        message.setTo("mission_list_notice@shux07.photomask.com");
        message.setSubject("Daily Issue Report");
        message.setText(emailBody.toString());
        javaMailSender.send(message);
    }
}
