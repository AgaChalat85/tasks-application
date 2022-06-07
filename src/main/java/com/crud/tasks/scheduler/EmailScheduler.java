package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private static final String MESSAGE_Template ="Currently in database you got: %d %s";
    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    public EmailScheduler(SimpleEmailService simpleEmailService, TaskRepository taskRepository, AdminConfig adminConfig) {
        this.simpleEmailService = simpleEmailService;
        this.taskRepository = taskRepository;
        this.adminConfig = adminConfig;
    }

    //@Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        String messageContent = createMessageContent();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT,
                        messageContent,
                        null
                )
        );
    }

    private String createMessageContent() {
        long size = taskRepository.count();
        String task = size == 1 ? "task" : "tasks";
        return String.format(MESSAGE_Template, size, task);

    }
}
