package com.agharibi.service;

import com.agharibi.persistence.dao.RoleJpaDao;
import com.agharibi.persistence.model.Role;
import com.agharibi.persistence.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

    @Autowired
    private RoleJpaDao roleJpaDao;

    public RoleServiceImpl() {
    }

    @Override
    public Role findByName(String name) {
        return this.getDao().findByName(name);
    }

    @Override
    public Role create(Role entity) {
        return super.create(entity);
    }

    @Override
    protected RoleJpaDao getDao() {
        return roleJpaDao;
    }

    @Override
    protected JpaSpecificationExecutor<Role> getSpecificationExecutor() {
        return roleJpaDao;
    }
}
