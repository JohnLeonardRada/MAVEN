package com.exist.model;

import java.util.Set;

@SuppressWarnings("rawtypes")
public class Role {
    private int id;
    private String roleName;
    private Set persons;
    private Set roles;

    public Role(){}

    public Role(String roleName){
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set getPersons() {
        return persons;
    }

    public void setPersons(Set persons) {
        this.persons = persons;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;
  
        Role obj2 = (Role)obj;
        if((this.id == obj2.getId()) && (this.roleName.equals(obj2.getRoleName()))) {
           return true;
        }
        return false;
     }
     
    public int hashCode() {
        int tmp = 0;
        tmp = (id + roleName).hashCode();
        return tmp;
    }

}
