package com.email.visitor;

import com.email.Element;
import com.email.ElementType;
import com.email.IEmailMessage;
import com.email.iterator.EmailIterator;

import java.util.ArrayList;
import java.util.List;

public class FindEmail implements Visitor {
    private List<Element> emailsFound;
    private String criteria;

    public FindEmail(String criteria) {
        this.criteria = criteria;
        this.emailsFound = new ArrayList<>();
    }

    @Override
    public void visit(Element element) {
        EmailIterator it = element.getIterator();
        while (it.hasNext()) {
            if (it.next().getType() == ElementType.Message) {
                IEmailMessage item = (IEmailMessage)it.current();
                if (item.getFrom().contains(this.criteria) ||
                    item.getSubject().contains(this.criteria) ||
                    item.getBody().contains(this.criteria)) {
                    this.emailsFound.add(it.current());
                }
            }

        }
    }

    @Override
    public List<Element> getVisited() {
        return this.emailsFound;
    }
}
