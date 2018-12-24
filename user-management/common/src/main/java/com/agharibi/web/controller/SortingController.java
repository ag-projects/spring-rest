package com.agharibi.web.controller;

import com.agharibi.persistence.model.Entity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SortingController<T extends Entity> {

    List<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    List<T> findAllPaginated(final int page, final int size);

    List<T> findAllSorted(final String sortBy, final String sortOrder);

    List<T> findAll(final HttpServletRequest request);
}
