package com.email.visitor;

import com.email.Element;
import com.email.ElementType;
import com.email.Folder;
import com.email.Message;
import com.email.iterator.EmailIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la busqueda de correos implementando la interfaz Visitor.
 * La busqueda la realiza por contenido del texto buscado en los campos from,
 * subject y body de los correos.
 */
public class FindEmail implements Visitor {
    private List<Element> emailsFound;
    private String criteria;

    /**
     * Constructor que recibe el texto que sera buscado en la lista de correos
     * que almacena la clase.
     *
     * @param criteria
     */
    public FindEmail(String criteria) {
        this.criteria = criteria;
        this.emailsFound = new ArrayList<>();
    }

    @Override
    public void visit(Element element) {
        EmailIterator it = ((Folder)element).getIterator();
        while (it.hasNext()) {
            if (it.next().getType() == ElementType.Message) {
                Message item = (Message)it.current();
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
