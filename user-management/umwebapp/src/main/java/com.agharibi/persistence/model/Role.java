package com.agharibi.persistence.model;

import com.agharibi.interfaces.NameableDto;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Role implements  NameableEntity, NameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PRIV_ID", referencedColumnName = "PRIV_ID") })
    private Set<Privilege> privileges;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Set<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id  = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return getName() != null ? getName().equals(role.getName()) : role.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
