package com.exist.model;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class RoleTest {
    
    @Test
    public void testAddRole(){
        Role role = new Role("Admin");

        Assert.assertTrue(role.getRoleName() == "Admin");
    }

    @Test
    public void testChangeRole(){
        Role role = new Role();

        role.setId(1);
        role.setRoleName("Admin");

        Assert.assertTrue(role.getId() == 1);
        Assert.assertTrue(role.getRoleName() == "Admin");
    }

    @Test
    public void testAddRoleToPerson(){
        Role role = new Role();
        
        HashSet<Role> roles = new HashSet<>();
        roles.add(new Role("HackerMan"));

        role.setRoles(roles);
        
        Assert.assertTrue(role.getRoles() == roles);
    }

    @Test
    public void testEquals(Object obj){
        Role role = new Role();
        Role obj2 = (Role)obj;

        Assert.assertEquals(false, role.equals(obj2));

        obj2.setId(1);
        obj2.setRoleName("HackerMan");
        Assert.assertEquals(true, (obj2.getId() == 1));
        Assert.assertEquals(true, (obj2.getRoleName() == "HackerMan"));
        Assert.assertEquals(obj2.getId() + obj2.getRoleName(), role.hashCode());
    }
}
