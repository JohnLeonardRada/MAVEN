package com.exist.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.exist.dao.RoleDao;
import com.exist.model.Person;
import com.exist.model.Role;

import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageRole implements RoleDao {
    private static SessionFactory factory; 
    
    public void createSessions(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }   
    }

    /* Method to add a role record to person in the database */
    @SuppressWarnings("rawtypes")
    public Integer addRoleToPerson(Integer PersonID, Set roles){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer personID = null;
        
        try {
            tx = session.beginTransaction();
            Person person = (Person)session.get(Person.class, PersonID);
            person.setRoles(roles);
            personID = (Integer) session.save(person); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        return personID;
    }

    /* Method to delete a role record from a person in the database */
    @SuppressWarnings("rawtypes")
    public void deleteRoleFromPerson(Integer PersonID, Integer RoleID){
        Session session = factory.openSession();
        Transaction tx = null;
        Set roles = null;
        Set persons = null;
        try {
            tx = session.beginTransaction();

            Person person = (Person)session.get(Person.class, PersonID);
            person.setRoles(roles);
            Role role = (Role)session.get(Role.class, RoleID);
            role.setPersons(persons);
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to add role in the database */
    public Integer addRole(String roleName){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer roleID = null;
        
        try {
            tx = session.beginTransaction();
            Role role = new Role(roleName);
            roleID = (Integer) session.save(role); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        return roleID;
    }

    /* Method to update roles for a person */
    public void updateRole(Integer RoleID, String roleName){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Role role = (Role)session.get(Role.class, RoleID); 
            role.setRoleName(roleName);
            session.update(role);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to delete a role from the records */
    public void deleteRole(Integer RoleID){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Role role = (Role)session.get(Role.class, RoleID); 
            session.delete(role); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to list all the roles detail */
    @SuppressWarnings("rawtypes")
    public void listRoles(){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            List roles = session.createQuery("FROM Role").list(); 
        for (Iterator iterator1 = roles.iterator(); iterator1.hasNext();){
            Role role = (Role) iterator1.next(); 
            System.out.println("Role Name: " + role.getRoleName());
        }
        tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

}
