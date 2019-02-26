package com.email;

/**
 * Interfaz que define las tareas mas generales para los elementos
 * que intervienen en la aplicación. Permite englobar a los elementos
 * como Folder y Mensajes de correo electrónico.
 */
public interface Element {
    /**
     * Permite desplegar el contenido de un elemento, ya sea un Folder
     * con una lista de mensajes o un mensaje que despliega su contenido.
     */
    void displayContent();

    /**
     * Retorna el tipo de elemento con el que se trabaja, ya sea Folder
     * o Mensaje.
     *
     * @return
     */
    ElementType getType();
}
