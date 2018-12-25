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
    private PrivilegeJpaDao privilegeJpaDao;

    public PrivilegeServiceImpl() {
    }

    @Override
    public Privilege findByName(String name) {
        return this.getDao().findByName(name);
    }

    @Override
    protected PrivilegeJpaDao getDao() {
        return this.privilegeJpaDao;
    }

    @Override
    protected JpaSpecificationExecutor<Privilege> getSpecificationExecutor() {
        return this.privilegeJpaDao;
    }
}
