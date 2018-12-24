package com.agharibi.persistence.service;

import com.agharibi.persistence.model.NameableEntity;

public abstract class AbstractService<T extends NameableEntity> extends AbstractRawService<T> implements Service<T> {

    public AbstractService() {
    }
}
