package com.email;

import com.email.iterator.EmailIterator;
import com.email.iterator.EmailIteratorImpl;
import com.email.visitor.FindEmail;
import com.email.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Element {

    private String folderName;
    private ElementType elementType;
    private List<Element> folderContent;

    public Folder(String folderName){
        this.folderName = folderName;
        this.folderContent = new ArrayList<>();
        this.elementType = ElementType.Folder;
    }

    @Override
    public void addChildElement(Element element)
    {
        this.folderContent.add(element);
    }

    @Override
    public void displayContent() {
        System.out.println(">>" + this.folderName);

        for (Element element : folderContent) {
            element.displayContent();
        }
    }

    @Override
    public EmailIterator getIterator() {
        return new EmailIteratorImpl(this.folderContent);
    }

    @Override
    public Visitor getVisitor(String criteria) {
        return new FindEmail(criteria);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    //    public boolean MoveMessage(String msgId, String destination)
//    {
//        Element message = GetMessage(msgId);
//
//        if(message != null)
//        {
//            Element folder = GetMessage(destination);
//
//
//            if(folder == null)
//                folder = new Folder(destination, new ArrayList<>());
//
//            //TODO implements return new folder to be added to the Root
//
//            if(folderContent.remove(message))
//            {
//                folder.addChildElement(message);
//                return true;
//            }
//
//        }
//        return false;
//    }

//    private Element GetMessage(String msgId)
//    {
//        Element message = null;
//
//        for(Element element : folderContent)
//        {
//            if(element.getType() == ElementType.Message)
//            {
//                UUID id = UUID.fromString(msgId);
//
//                if(id.equals( ((EmailMessage) element).getMsgId()))
//                {
//                    return message;
//                }
//            }
//
//            if(element.getType() == ElementType.Folder)
//            {
//                if(msgId.equals( ((Folder) element).folderName ))
//                {
//                    return  element;
//                }
//            }
//        }
//
//        return message;
//    }

//    private boolean MoveMessage(String destination, Element message)
//    {
//        IAction move = new Move( ((EmailMessage) message).getMsgId(), destination);
//        return move.ExecuteAction();
//    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }


}
