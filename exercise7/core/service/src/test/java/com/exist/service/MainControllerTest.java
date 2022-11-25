package com.exist.service;

import java.time.LocalDate;

import com.exist.model.Person;

import org.junit.Test;

public class MainControllerTest {
    ManagePerson mp = new ManagePerson();
    Person person = new Person();
    @Test
    public void testAddPerson(){
        mp.createSessions();

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

        //mp.addPerson(person.getFirstName(), person.getMiddleName(), person.getLastName(), suffix, title, streetNo, barangay, city, zipCode, birthday, gwa, dateHired, isEmployed)
        //Assert.assertEquals(expected, actual);
    }

}
