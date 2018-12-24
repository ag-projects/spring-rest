package com.agharibi.web.controller;

import com.agharibi.persistence.model.NameableEntity;
import com.agharibi.web.RestPreconditions;

public abstract class AbstractController<T extends NameableEntity> extends AbstractReadOnlyController<T> {

    protected final void createInternal(final T resource) {
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestState(resource.getId() == null);
        getService().create(resource);
    }

    protected final void updateInternal(final long id, final T resource) {
        RestPreconditions.checkRequestElementNotNull(resource);
        RestPreconditions.checkRequestElementNotNull(resource.getId());
        RestPreconditions.checkRequestState(resource.getId() == id);
        RestPreconditions.checkNotNull(getService().findOne(resource.getId()));

        getService().update(resource);
    }

    protected final void deleteByIdInternal(final long id) {
        getService().delete(id);
    }
}
