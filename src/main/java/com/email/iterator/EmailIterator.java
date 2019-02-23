package com.email.iterator;

import com.email.Element;

public interface EmailIterator {
    boolean hasNext();

    Element next();

    Element current();

    void begin();
}
