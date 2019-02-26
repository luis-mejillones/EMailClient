package com.email.visitor;

import com.email.Element;

import java.util.List;

public interface Visitor {
    /**
     * Permite realizar la tarea de visita a cada elemento.
     *
     * @param element
     */
    void visit(Element element);

    /**
     * Permite retornar el resultado de los elementos visitados.
     *
     * @return
     */
    List<Element> getVisited();
}
