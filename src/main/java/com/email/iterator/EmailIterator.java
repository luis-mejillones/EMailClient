package com.email.iterator;

import com.email.Element;

/**
 * Interfaz que define la funcionalidad del patron Iterator
 */
public interface EmailIterator {
  /**
   * indica si existen mas elementos en la lista. Retorna verdad si
   * existen mas elementos y falso en caso contrario
   *
   * @return
   */
  boolean hasNext();

  /**
   * Retorna el siguiente elemento en la lista avanzando el indice.
   *
   * @return
   */
  Element next();

  /**
   * Retorna el elemento que indica el indice sin mover el indice.
   *
   * @return
   */
  Element current();
}
