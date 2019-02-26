package com.email;

import com.email.iterator.EmailIterator;
import com.email.iterator.EmailIteratorImpl;
import com.email.visitor.FindEmail;
import com.email.visitor.Visitable;
import com.email.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la funcionalidad de un Folder.
 * Como mienbros define el nombre del folder, el tipo
 * de elemento y la lista de elementos que contiene.
 */
public class FolderImpl implements Folder, Visitable {
    private String name;
    private ElementType elementType;
    private List<Element> content;

    /**
     * Constructor que recibe el nombre para el folder.
     *
     * @param name
     */
    public FolderImpl(String name){
        this.name = name;
        this.content = new ArrayList<>();
        this.elementType = ElementType.Folder;
    }

    @Override
    public void addElement(Element element)
    {
        this.content.add(element);
    }

    @Override
    public void displayContent() {
        System.out.println(">>" + this.name);

        content.stream().forEach(item -> item.displayContent());
    }

    @Override
    public EmailIterator getIterator() {
        return new EmailIteratorImpl(this.content);
    }

    @Override
    public Visitor getVisitor(String criteria) {
        return new FindEmail(criteria);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }
}
