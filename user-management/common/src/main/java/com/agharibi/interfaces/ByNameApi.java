package com.agharibi.interfaces;

public interface ByNameApi<T extends WithName> {

    T findByName(final String name);
}
