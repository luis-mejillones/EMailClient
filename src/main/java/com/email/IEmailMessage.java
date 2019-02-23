package com.email;

public interface IEmailMessage {
    String getTo();
    String getFrom();
    String getSent();
    String getCC();
    String getSubject();
    String getBody();

    void setTo(String to);
    void setFrom(String from);
    void setSent(String sent);
    void setCC(String cc);
    void setSubject(String subject);
    void setBody(String body);
}
