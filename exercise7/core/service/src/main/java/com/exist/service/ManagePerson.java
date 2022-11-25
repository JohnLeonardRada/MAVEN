package com.exist.service;

import java.time.LocalDate;
import java.util.*;

import com.exist.dao.PersonDao;
import com.exist.model.Contact;
import com.exist.model.Person;

import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManagePerson implements PersonDao{
    private static SessionFactory factory; 
    
    public void createSessions(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { 
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex); 
        }   
    }

    /* Method to add an person record in the database */
    public Integer addPerson(String firstName, String middleName, String lastName, String suffix, String title,
                                int streetNo, String barangay, String city, int zipCode, 
                                LocalDate birthday, int gwa, LocalDate dateHired, boolean isEmployed){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer personID = null;
        
        try {
            tx = session.beginTransaction();
            Person person = new Person(firstName, middleName, lastName, suffix, title,
                                        streetNo, barangay, city, zipCode,
                                        birthday, gwa, dateHired, isEmployed);
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

    /* Method to update details for a person */
    public void updatePerson(Integer PersonID, String firstName, String middleName, String lastName, String suffix, String title,
                                int streetNo, String barangay, String city, int zipCode, 
                                LocalDate birthday, int gwa, LocalDate dateHired, boolean isEmployed){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = (Person)session.get(Person.class, PersonID); 
            person.setFirstName(firstName);
            person.setMiddleName(middleName);
            person.setLastName(lastName);
            person.setSuffix(suffix);
            person.setTitle(title);;
            person.setStreetNo(streetNo);
            person.setBarangay(barangay);
            person.setCity(city);
            person.setZipCode(zipCode);
            person.setBirthday(birthday);
            person.setGwa(gwa);
            person.setDateHired(dateHired);
            person.setEmployed(isEmployed);
            session.update(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to delete a person from the records */
    public void deletePerson(Integer PersonID){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Person person = (Person)session.get(Person.class, PersonID); 
            session.delete(person); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to list all the persons detail by date hired*/
    @SuppressWarnings("rawtypes")
    public void listPersonsByGWA(){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            // String hql = "FROM Person p ORDER BY p.lastName";
            // Query query = session.createQuery(hql);
            List persons = session.createQuery("FROM Person p ORDER BY p.gwa").list(); 
            for (Iterator iterator1 = persons.iterator(); iterator1.hasNext();){
                Person person = (Person) iterator1.next(); 
                System.out.println(" First Name: " + person.getFirstName()); 
                System.out.println("Middle Name: " + person.getMiddleName()); 
                System.out.println("  Last Name: " + person.getLastName()); 
                System.out.println("     Suffix: " + person.getSuffix()); 
                System.out.println("      Title: " + person.getTitle()); 
                System.out.println(" Street No.: " + person.getStreetNo()); 
                System.out.println("   Barangay: " + person.getBarangay()); 
                System.out.println("       City: " + person.getCity()); 
                System.out.println("   Zip Code: " + person.getZipCode()); 
                System.out.println("   Birthday: " + person.getBirthday()); 
                System.out.println("        GWA: " + person.getGwa()); 
                System.out.println(" Date Hired: " + person.getDateHired()); 
                System.out.println("   Employed: " + person.getEmployed()); 
                System.out.println("------------------------"); 
                Set contacts = person.getContacts();
                for (Iterator iterator2 = contacts.iterator(); iterator2.hasNext();){
                    Contact contact = (Contact) iterator2.next(); 
                    System.out.println("   Landline: " + contact.getLandline()); 
                    System.out.println(" Mobile No.: " + contact.getLandline()); 
                    System.out.println("      Email: " + contact.getLandline()); 
                }
            }
        tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to list all the persons detail by date hired*/
    @SuppressWarnings("rawtypes")
    public void listPersonsByDateHired(){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            // String hql = "FROM Person p ORDER BY p.lastName";
            // Query query = session.createQuery(hql);
            List persons = session.createQuery("FROM Person p ORDER BY p.dateHired").list(); 
            for (Iterator iterator1 = persons.iterator(); iterator1.hasNext();){
                Person person = (Person) iterator1.next(); 
                System.out.println(" First Name: " + person.getFirstName()); 
                System.out.println("Middle Name: " + person.getMiddleName()); 
                System.out.println("  Last Name: " + person.getLastName()); 
                System.out.println("     Suffix: " + person.getSuffix()); 
                System.out.println("      Title: " + person.getTitle()); 
                System.out.println(" Street No.: " + person.getStreetNo()); 
                System.out.println("   Barangay: " + person.getBarangay()); 
                System.out.println("       City: " + person.getCity()); 
                System.out.println("   Zip Code: " + person.getZipCode()); 
                System.out.println("   Birthday: " + person.getBirthday()); 
                System.out.println("        GWA: " + person.getGwa()); 
                System.out.println(" Date Hired: " + person.getDateHired()); 
                System.out.println("   Employed: " + person.getEmployed()); 
                System.out.println("------------------------"); 
                Set contacts = person.getContacts();
                for (Iterator iterator2 = contacts.iterator(); iterator2.hasNext();){
                    Contact contact = (Contact) iterator2.next(); 
                    System.out.println("   Landline: " + contact.getLandline()); 
                    System.out.println(" Mobile No.: " + contact.getLandline()); 
                    System.out.println("      Email: " + contact.getLandline()); 
                }
            }
        tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }

    /* Method to list all the persons detail by last name*/
    @SuppressWarnings("rawtypes")
    public void listPersonsByLastName(){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            // String hql = "FROM Person p ORDER BY p.lastName";
            // Query query = session.createQuery(hql);
            List persons = session.createQuery("FROM Person p ORDER BY p.dateHired").list(); 
            for (Iterator iterator1 = persons.iterator(); iterator1.hasNext();){
                Person person = (Person) iterator1.next(); 
                System.out.println(" First Name: " + person.getFirstName()); 
                System.out.println("Middle Name: " + person.getMiddleName()); 
                System.out.println("  Last Name: " + person.getLastName()); 
                System.out.println("     Suffix: " + person.getSuffix()); 
                System.out.println("      Title: " + person.getTitle()); 
                System.out.println(" Street No.: " + person.getStreetNo()); 
                System.out.println("   Barangay: " + person.getBarangay()); 
                System.out.println("       City: " + person.getCity()); 
                System.out.println("   Zip Code: " + person.getZipCode()); 
                System.out.println("   Birthday: " + person.getBirthday()); 
                System.out.println("        GWA: " + person.getGwa()); 
                System.out.println(" Date Hired: " + person.getDateHired()); 
                System.out.println("   Employed: " + person.getEmployed()); 
                System.out.println("------------------------"); 
                Set contacts = person.getContacts();
                for (Iterator iterator2 = contacts.iterator(); iterator2.hasNext();){
                    Contact contact = (Contact) iterator2.next(); 
                    System.out.println("   Landline: " + contact.getLandline()); 
                    System.out.println(" Mobile No.: " + contact.getLandline()); 
                    System.out.println("      Email: " + contact.getLandline()); 
                }
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
