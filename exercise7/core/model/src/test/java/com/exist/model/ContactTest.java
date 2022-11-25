package com.exist.model;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class ContactTest {
    
    @Test
    public void testAddContact(){
        Contact contact = new Contact(123456789, 987654321, "abc@gmail.com");

        Assert.assertTrue(contact.getLandline() == 123456789);
        Assert.assertTrue(contact.getMobileNumber() == 987654321);
        Assert.assertTrue(contact.getEmail() == "abc@gmail.com");
    }

    @Test 
    public void testChangeContact(){
        Contact contact = new Contact();

        contact.setId(1);
        contact.setLandline(123456789);
        contact.setMobileNumber(987654321);
        contact.setEmail("abc@gmail.com");

        Assert.assertTrue(contact.getId() == 1);
        Assert.assertTrue(contact.getLandline() == 123456789);
        Assert.assertTrue(contact.getMobileNumber() == 987654321);
        Assert.assertTrue(contact.getEmail() == "abc@gmail.com");
    }

    @Test
    public void testAddContactToPerson(){
        Contact contact = new Contact();

        HashSet<Contact> contacts = new HashSet<>();
        contacts.add(new Contact(123456789, 987654321, "abc@gmail.com.ph"));
        
        contact.setContacts(contacts);

        Assert.assertTrue(contact.getContacts() == contacts);
    }

    @Test
    public void testEquals(Object obj){
        Contact contact = new Contact();
        Contact obj2 = (Contact)obj;

        Assert.assertEquals(false, contact.equals(obj2));

        obj2.setId(1);
        obj2.setLandline(111111);
        obj2.setMobileNumber(222222);
        obj2.setEmail("abc@gmail.com");

        Assert.assertEquals(true, (obj2.getId() == 1));
        Assert.assertEquals(true, (obj2.getLandline() == 111111));
        Assert.assertEquals(true, (obj2.getMobileNumber() == 222222));
        Assert.assertEquals(true, (obj2.getEmail() == "abc@gmail.com"));
        Assert.assertTrue(obj2.getId() + obj2.getLandline() + obj2.getMobileNumber() == contact.hashCode());
    }
}
