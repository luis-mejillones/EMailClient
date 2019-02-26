package com.email;

import java.util.UUID;

/**
 * Clase que representa a cada mensaje de correo electrónico y define
 * todos los elementos que compone un mensaje.
 */
public class EmailMessage implements Message {
  private String msgId;
  private String to;
  private String from;
  private String sent;
  private String subject;
  private String body;
  private ElementType elementType;

  /**
   * Constructor que permite definir directamente un mensaje sin necesidad
   * de invocar a sus setters.
   *
   * @param to
   * @param from
   * @param sent
   * @param subject
   * @param body
   */
  public EmailMessage(String to, String from, String sent, String subject, String body) {
    this.to = to;
    this.from = from;
    this.sent = sent;
    this.subject = subject;
    this.body = body;
    this.elementType = ElementType.Message;
    this.msgId = UUID.randomUUID().toString().toUpperCase().replace("-", "");
  }

  public String getTo() {
    return to;
  }

  public String getMsgId() {
    return msgId;
  }

  public String getFrom() {
    return from;
  }

  public String getSent() {
    return sent;
  }

  @Override
  public String getCC() {
    return null;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  @Override
  public void setTo(String to) {
    this.to = to;
  }

  @Override
  public void setFrom(String from) {
    this.from = from;
  }

  @Override
  public void setSent(String sent) {
    this.sent = sent;
  }

  @Override
  public void setCC(String cc) {

  }

  @Override
  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public void displayContent() {
    System.out.println("  msgId: " + this.msgId);
    System.out.println("  to: " + this.to);
    System.out.println("  from: " + this.from);
    System.out.println("  sent: " + this.sent);
    System.out.println("  subject: " + this.subject);
    System.out.println("  Message body: " + this.body);
    System.out.println();
  }

  @Override
  public ElementType getType() {
    return elementType;
  }
}
