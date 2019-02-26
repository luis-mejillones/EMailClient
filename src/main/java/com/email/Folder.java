package com.email;

import com.email.iterator.EmailIterator;
import com.email.visitor.Visitor;

/**
 * Interfaz que define la funcionalidad de un Folder.
 * Ademas define algunas constantes para los nombres
 * de folders que siempre deben estar presentes en la
 * aplicación.
 */
public interface Folder extends Element {
    String FOLDER_INBOX_NAME = "Inbox";
    String FOLDER_SENT_NAME = "Send";
    String FOLDER_TRASH_NAME = "Trash";

    /**
     * Permite retornar un Iterador que sera utilizado
     * para hacer recorridos en la lista de mensajes
     * que pueda contener el folder.
     *
     * @return
     */
    EmailIterator getIterator();

    /**
     * Retorna un visitor que sera utilizado para realizar
     * operaciones con cada mensje, en este caso realizar
     * la busqueda en el contenido de cada mensaje.
     *
     * @param criteria Criterio de busqueda
     *
     * @return
     */
    Visitor getVisitor(String criteria);

    /**
     * Permite agregar elementos en un folder, ya sean estos
     * Mensajes o un Folder
     *
     * @param element
     */
    void addElement(Element element);
}
