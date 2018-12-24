package com.agharibi.persistence.service;

import com.agharibi.interfaces.ByNameApi;
import com.agharibi.interfaces.WithName;

public interface Service<T extends WithName> extends RawService<T>, ByNameApi<T> {
}
