package com.agharibi.persistence.service;

import com.agharibi.interfaces.WithName;
import com.agharibi.persistence.ServicePreconditions;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractRawService<T extends WithName> implements RawService<T> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public AbstractRawService() {
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAllPaginatedAndSortedRaw(int page, int size, String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        return getDao().findAll(new PageRequest(page, size, sortInfo));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAllPaginatedRaw(int page, int size) {
        return getDao().findAll(new PageRequest(page, size));
    }

    @Override
    @Transactional(readOnly = true)
    public T findOne(long id) {
        T entity = getDao().findOne(id);
        return entity;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllSorted(String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        return Lists.newArrayList(getDao().findAll(sortInfo));
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllPaginated(int page, int size) {
        final List<T> content = getDao().findAll(new PageRequest(page, size, null)).getContent();
        if(content == null) {
            return Lists.newArrayList();
        }
        return content;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        final Sort sortInfo = constructSort(sortBy, sortOrder);
        final List<T> content = getDao().findAll(new PageRequest(page, size, sortInfo)).getContent();
        if (content == null) {
            return Lists.newArrayList();
        }
        return content;
    }

    @Override
    public T create(T entity) {
        Preconditions.checkNotNull(entity);
        T persistedEntity = this.getDao().save(entity);
        return persistedEntity;
    }

    @Override
    public void update(T entity) {
        Preconditions.checkNotNull(entity);
        this.getDao().save(entity);
    }

    @Override
    public void delete(long id) {
        T entity = getDao().findOne(id);
        if(entity != null) {
            ServicePreconditions.checkEntityExists(entity);
            getDao().delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        this.getDao().deleteAll();
    }

    @Override
    public long count() {
        return this.getDao().count();
    }

    protected abstract PagingAndSortingRepository<T, Long> getDao();

    protected abstract JpaSpecificationExecutor<T> getSpecificationExecutor();

    protected final Sort constructSort(final String sortBy, final String sortOrder) {
        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Sort.Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }
}
