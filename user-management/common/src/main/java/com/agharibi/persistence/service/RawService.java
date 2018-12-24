package com.agharibi.persistence.service;

import com.agharibi.interfaces.Operations;
import com.agharibi.interfaces.WithName;
import org.springframework.data.domain.Page;

public interface RawService<T extends WithName> extends Operations<T> {

    Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);
    Page<T> findAllPaginatedRaw(final int page, final int size);
}
