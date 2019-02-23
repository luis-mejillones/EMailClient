package com.email;

import com.email.iterator.EmailIterator;
import com.email.visitor.Visitable;
import com.email.visitor.Visitor;

public abstract class Element implements Visitable {
    public static final String FOLDER_INBOX_NAME = "Inbox";
    public static final String FOLDER_SENT_NAME = "Send";
    public static final String FOLDER_TRASH_NAME = "Trash";

    public abstract void addChildElement(Element element);

    public abstract void displayContent();
    public abstract ElementType getType();

    public abstract EmailIterator getIterator();

    public abstract Visitor getVisitor(String criteria);
}
