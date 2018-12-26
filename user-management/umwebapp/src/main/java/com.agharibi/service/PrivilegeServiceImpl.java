package com.agharibi.service;

import com.agharibi.persistence.dao.PrivilegeJpaDao;
import com.agharibi.persistence.model.Privilege;
import com.agharibi.persistence.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrivilegeServiceImpl extends AbstractService<Privilege> implements PrivilegeService {

    @Autowired
    private PrivilegeJpaDao dao;

    public void setDao(PrivilegeJpaDao dao) {
        this.dao = dao;
    }

    public PrivilegeServiceImpl() {
    }

    @Override
    public Privilege findByName(String name) {
        return this.getDao().findByName(name);
    }

    @Override
    protected PrivilegeJpaDao getDao() {
        return this.dao;
    }

    @Override
    protected JpaSpecificationExecutor<Privilege> getSpecificationExecutor() {
        return this.dao;
    }
}
