package com.crud.tasks.domain;



public class Mail {

    private final String mailTo;
    private final String subject;
    private final String message;
    private  String toCC;

    public Mail(String mailTo, String subject, String message, String toCC) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.toCC = toCC;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getToCC() {
        return toCC;
    }
}
