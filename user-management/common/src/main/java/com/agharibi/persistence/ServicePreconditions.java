package com.agharibi.persistence;

import com.agharibi.persistence.exception.MyEntityNotFoundException;

public final class ServicePreconditions {

    private ServicePreconditions() {
        throw new AssertionError();
    }

    public static <T> T checkEntityExists(final T entity) {
        if (entity == null) {
            throw new MyEntityNotFoundException();
        }
        return entity;
    }

    public static void checkEntityExists(final boolean entityExists) {
        if (!entityExists) {
            throw new MyEntityNotFoundException();
        }
    }

    public static void checkOKArgument(final boolean okArgument) {
        if (!okArgument) {
            throw new MyBadRequestException();
        }
    }
}
