package com.exist.dao;

import java.util.Set;

@SuppressWarnings("rawtypes")
public interface RoleDao {
    public void createSessions();
    public Integer addRoleToPerson(Integer PersonID, Set roles);
    public void deleteRoleFromPerson(Integer PersonID, Integer RoleID);
    public Integer addRole(String roleName);
    public void updateRole(Integer RoleID, String roleName);
    public void deleteRole(Integer RoleID);
    public void listRoles();
}
