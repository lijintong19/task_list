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

    /**
     * 服务器是时间和现实时间相差12小时
     */
    @Scheduled(cron = "0 0 5 * * ?")
    public void sendEmailMorning() {
        sendEmail();
    }

    /**
     * 服务器是时间和现实时间相差12小时
     */
    @Scheduled(cron = "0 0 21 * * ?")
    public void sendEmailAfternoon() {
        sendEmail();
    }

    private void sendEmail() {
        List<IssueRecordTable> data = issueRecordService.getListByStatus();
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("Hi All,\n\n");
        emailBody.append("Below is the daily tasks report:\n\n");

        if (!data.isEmpty()) {
            emailBody.append("On going Tasks:\n");
            for (IssueRecordTable record : data) {
                if ("On going".equals(record.getIssueStatus())) {
                    emailBody.append(" -Task Description: ")
                            .append(record.getIssueDescription().trim())
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
        String[] to = { "chensy@photomask.com", "lijt@photomask.com", "longy@photomask.com", "ChenC@photomask.com",
                "linzh@photomask.com" };
        message.setFrom("reportPlatform@tpcs.com");
        message.setTo(to);
        message.setSubject("Daily Tasks Report");
        message.setText(emailBody.toString());
        javaMailSender.send(message);
    }
}
