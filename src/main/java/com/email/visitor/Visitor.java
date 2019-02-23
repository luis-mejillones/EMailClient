package com.email.visitor;

import com.email.Element;

import java.util.List;

public interface Visitor {
    void visit(Element element);

    List<Element> getVisited();
}
