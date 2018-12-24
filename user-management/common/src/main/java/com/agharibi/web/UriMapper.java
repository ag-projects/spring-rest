package com.agharibi.web;

import com.agharibi.persistence.model.Entity;

public interface UriMapper {

    <T extends Entity> String getUriBase(final Class<T> clazz);
}
