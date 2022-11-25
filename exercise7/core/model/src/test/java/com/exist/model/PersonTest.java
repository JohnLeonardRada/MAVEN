package com.exist.model;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    
    @Test
    public void testAddPerson(){
        Person person = new Person("John", "Leonard", "Rada", "Jr.", "Intern", 123, "Barangay 123", "Caloocan City", 1400, LocalDate.of(1999,6,05), 1, LocalDate.of(2021, 8, 23), true);
        
        Assert.assertTrue(person.getFirstName() == "John");
        Assert.assertTrue(person.getMiddleName() == "Leonard");
        Assert.assertTrue(person.getLastName() == "Rada");
        Assert.assertTrue(person.getSuffix() == "Jr.");
        Assert.assertTrue(person.getTitle() == "Intern");
        Assert.assertTrue(person.getStreetNo() == 123);
        Assert.assertTrue(person.getBarangay() == "Barangay 123");
        Assert.assertTrue(person.getCity() == "Caloocan City");
        Assert.assertTrue(person.getZipCode() == 1400);
        Assert.assertEquals(person.getBirthday(), LocalDate.of(1999,6,05));
        Assert.assertTrue(person.getGwa() == 1);
        Assert.assertEquals(person.getDateHired(), LocalDate.of(2021,8,23));
        Assert.assertEquals(person.getEmployed(), true);
    }

    @Test
    public void testChangePerson(){
        Person person = new Person();

        person.setId(1);
        person.setFirstName("John");
        person.setMiddleName("Leonard");
        person.setLastName("Rada");
        person.setSuffix("Jr.");
        person.setTitle("Intern");
        person.setStreetNo(123);
        person.setBarangay("Barangay 123");
        person.setCity("Caloocan City");
        person.setZipCode(1400);
        person.setBirthday(LocalDate.of(1999,6,05));
        person.setGwa(1);
        person.setDateHired(LocalDate.of(2021,8,23));
        person.setEmployed(true);

        Assert.assertTrue(person.getId() == 1);
        Assert.assertTrue(person.getFirstName() == "John");
        Assert.assertTrue(person.getMiddleName() == "Leonard");
        Assert.assertTrue(person.getLastName() == "Rada");
        Assert.assertTrue(person.getSuffix() == "Jr.");
        Assert.assertTrue(person.getTitle() == "Intern");
        Assert.assertTrue(person.getStreetNo() == 123);
        Assert.assertTrue(person.getBarangay() == "Barangay 123");
        Assert.assertTrue(person.getCity() == "Caloocan City");
        Assert.assertTrue(person.getZipCode() == 1400);
        Assert.assertEquals(person.getBirthday(), LocalDate.of(1999,6,05));
        Assert.assertTrue(person.getGwa() == 1);
        Assert.assertEquals(person.getDateHired(), LocalDate.of(2021,8,23));
        Assert.assertEquals(person.getEmployed(), true);
    }

    @Test
    public void testAddContactAndRole(){
        Person person = new Person();

        HashSet<Contact> contacts = new HashSet<>();
        contacts.add(new Contact(123456789, 987654321, "abc@gmail.com.ph"));
        
        HashSet<Role> roles = new HashSet<>();
        roles.add(new Role("SpiderMan"));

        person.setContacts(contacts);
        person.setRoles(roles);

        Assert.assertTrue(person.getContacts() == contacts);
        Assert.assertTrue(person.getRoles() == roles);
    }
}
