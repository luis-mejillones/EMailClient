package com.email.visitor;

public interface Visitable {
    /**
     * Provee la capacidad de aceptar a los objetos que lo implementen.
     *
     * @param visitor
     */
    void accept(Visitor visitor);
}
