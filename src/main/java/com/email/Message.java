package com.email;

/**
 * Interface que define la funcionalidad para cada mensaje
 * de correo electrónico.
 * Esta interface extiende la interface Element para permitir
 * contener operaciones generales sobre cada mensaje.
 */
public interface Message extends Element {
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
