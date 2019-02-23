package com.email;

import com.email.iterator.EmailIterator;
import com.email.visitor.Visitor;

import java.util.List;
import java.util.UUID;

public class EmailMessage extends Element implements IEmailMessage {
    private UUID MsgId;
    private String To;
    private String From;
    private String Sent;
    private String Subject;
    private String Body;
    private ElementType elementType;
    private List<Element> folderContent;

    @Override
    public void addChildElement(Element element)
    {
        this.folderContent.add(element);
    }

    public String getTo() {
        return To;
    }

    public UUID getMsgId() {
        return MsgId;
    }

    public String getFrom() {
        return From;
    }

    public String getSent() {
        return Sent;
    }

    @Override
    public String getCC() {
        return null;
    }

    public String getSubject() {
        return Subject;
    }

    public String getBody() {
        return Body;
    }

    @Override
    public void setTo(String to) {
        this.To = to;

    }

    @Override
    public void setFrom(String from) {
        this.From = from;
    }

    @Override
    public void setSent(String sent) {
        this.Sent = sent;
    }

    @Override
    public void setCC(String cc) {

    }

    @Override
    public void setSubject(String subject) {
        this.Subject = subject;
    }

    @Override
    public void setBody( String body) {
        this.Body = body;
    }


    public EmailMessage(String to, String from, String sent, String subject, String body) {
        this.To = to;
        this.From = from;
        this.Sent = sent;
        this.Subject = subject;
        this.Body = body;
        this.elementType = ElementType.Message;
        this.MsgId = UUID.randomUUID();
    }

    public EmailMessage(){}

    public boolean isValidMessage()
    {
        return !this.Subject.isEmpty();
    }

    @Override
    public void displayContent() {
        System.out.println("  MsgId: " + this.MsgId);
        System.out.println("  To: " + this.To);
        System.out.println("  From: " + this.From);
        System.out.println("  Sent: " + this.Sent);
        System.out.println("  Subject: " + this.Subject);
        System.out.println("  Message Body: " + this.Body);
        System.out.println();
    }

    @Override
    public ElementType getType() {
        return elementType;
    }

    @Override
    public EmailIterator getIterator() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public Visitor getVisitor(String criteria) {
        return null;
    }
}
