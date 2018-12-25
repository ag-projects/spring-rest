package com.agharibi.persistence.dao;

import com.agharibi.interfaces.ByNameApi;
import com.agharibi.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrivilegeJpaDao extends JpaRepository<Privilege, Long>, JpaSpecificationExecutor<Privilege>, ByNameApi<Privilege> {

}
