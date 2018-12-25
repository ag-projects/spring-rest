package com.agharibi.service;

import com.agharibi.persistence.dao.UserJpaDao;
import com.agharibi.persistence.model.User;
import com.agharibi.persistence.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {

    @Autowired
    private UserJpaDao userJpaDao;

    public UserServiceImpl() {
    }

    @Override
    @Transactional(readOnly = true)
    public User findByName(String name) {
        return this.userJpaDao.findByName(name);
    }

    @Override
    protected UserJpaDao getDao() {
        return this.userJpaDao;
    }

    @Override
    protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
        return this.userJpaDao;
    }
}
