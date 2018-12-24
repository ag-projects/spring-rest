package com.agharibi.web.util;

import com.agharibi.web.exception.MyConflictException;
import com.agharibi.web.exceptions.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;

public final class RestUtil {

    private RestUtil() {
        throw new AssertionError();
    }

    public static void propagateStatusCodeOnCreate(final ResponseEntity<?> createResponse, final String message) {
        if (createResponse.getStatusCode().value() == 409) {
            throw new MyConflictException(message);
        }
        if (createResponse.getStatusCode().value() != 201) {
            throw new IllegalStateException(message);
        }
    }

    public static void propagateStatusCodeOnException(final HttpStatusCodeException ex, final String message) {
        if (ex.getStatusCode().value() == 409) {
            throw new ValidationException(ex.getStatusText());
        }

        throw new IllegalStateException(message);
    }
}
