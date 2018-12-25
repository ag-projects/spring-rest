package com.agharibi.persistence.dao;

import com.agharibi.interfaces.ByNameApi;
import com.agharibi.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserJpaDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, ByNameApi<User> {

}
