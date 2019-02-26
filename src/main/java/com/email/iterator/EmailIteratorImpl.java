package com.email.iterator;

import com.email.Element;

import java.util.List;

/**
 * Implementación de la interfaz EmailIterator
 * Define como datos la lista de elementos y el indice apuntador.
 */
public class EmailIteratorImpl implements EmailIterator {
  private List<Element> list;
  private int index;

  public EmailIteratorImpl(List<Element> list) {
    this.list = list;
    this.index = -1;
  }

  @Override
  public boolean hasNext() {
    return this.index < this.list.size() - 1;
  }

  @Override
  public Element next() {
    this.index++;

    return this.list.get(this.index);
  }

  @Override
  public Element current() {
    return this.list.get(this.index);
  }
}
