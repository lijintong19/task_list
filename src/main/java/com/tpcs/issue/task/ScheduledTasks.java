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

    @Scheduled(cron = "0/5 * * * * ?")
    public void sendEmail() {
        List<IssueRecordTable> data = issueRecordService.getListByStatus();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@tpcs.com");
        message.setTo("lijt@photomask.com");
        message.setSubject("Daily Issue Report");
        message.setText("Dear user,\n\n" + "This is the daily issue report for today:\n\n" + data.toString());

        javaMailSender.send(message);
    }
}
