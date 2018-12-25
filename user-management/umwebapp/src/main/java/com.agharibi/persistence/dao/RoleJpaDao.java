package com.agharibi.persistence.dao;

import com.agharibi.interfaces.ByNameApi;
import com.agharibi.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleJpaDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>, ByNameApi<Role> {

}
