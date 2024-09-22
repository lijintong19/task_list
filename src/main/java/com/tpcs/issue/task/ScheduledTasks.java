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

    @Scheduled(cron = "0 0 8,17 * * ?")
    public void sendEmail() {
        List<IssueRecordTable> data = issueRecordService.getListByStatus();
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Hi All,\n\n");
        emailBody.append("Below is the daily tasks report:\n\n");

        if (!data.isEmpty()) {
            emailBody.append("On going Tasks:\n");
            for (IssueRecordTable record : data) {
                if ("On going".equals(record.getIssueStatus())) {
                    emailBody.append(" -Task Description: ")
                            .append(record.getIssueDescription())
                            .append(" -Owner: ").append(record.getReportBy()).append("\n");
                } else {
                    emailBody.append("There is no on going tasks.\n");
                }
            }
        } else {
            emailBody.append("There is no tasks record for today.\n");
        }

        emailBody.append("\nBest regards,\nTask Platform");
        SimpleMailMessage message = new SimpleMailMessage();
        String[] to = {"chensy@photomask.com","lijt@photomask.com","longy@photomask.com","ChenC@photomask.com","linch@photomask.com"};
        message.setFrom("reportPlatform@tpcs.com");
        message.setTo(to);
        message.setSubject("Daily Tasks Report");
        message.setText(emailBody.toString());
        javaMailSender.send(message);
    }
}
