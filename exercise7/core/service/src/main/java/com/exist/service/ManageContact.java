package com.exist.service;

import java.util.Set;

import com.exist.dao.ContactDao;
import com.exist.model.Contact;
import com.exist.model.Person;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageContact implements ContactDao{
    private static SessionFactory factory; 
    
    public void createSessions(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }   
    }

    /* Method to add a contact record in the database */
    @SuppressWarnings("rawtypes")
    public Integer addContact(Integer PersonID, Set contacts){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer personID = null;
        
        try {
            tx = session.beginTransaction();
            Person person = (Person)session.get(Person.class, PersonID);
            person.setContacts(contacts);
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

    /* Method to update contact for a person */
    public void updateContact(Integer ContactID, double landline, double mobileNumber, String email){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Contact contact = (Contact)session.get(Contact.class, ContactID); 
            contact.setLandline(landline);
            contact.setMobileNumber(mobileNumber);
            contact.setEmail(email);
            session.update(contact);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to delete a contact from the records */
    public void deleteContact(Integer ContactID){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Contact contact = (Contact)session.get(Contact.class, ContactID); 
            session.delete(contact); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }
}
