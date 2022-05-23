package com.crud.tasks.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {

    @Value("${admin.mail}")
    private String adminMail;

    @Value("${admin.name}")
    private String adminName;

    public String getAdminMail() {
        return adminMail;
    }

    public String getAdminName() {
        return adminName;
    }
}
