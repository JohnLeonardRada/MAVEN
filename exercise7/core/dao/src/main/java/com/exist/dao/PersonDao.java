package com.exist.dao;

import java.time.LocalDate;

public interface PersonDao {
    public void createSessions();
    public Integer addPerson(String firstName, String middleName, String lastName, String suffix, String title,
                                int streetNo, String barangay, String city, int zipCode, 
                                LocalDate birthday, int gwa, LocalDate dateHired, boolean isEmployed);
    public void updatePerson(Integer PersonID, String firstName, String middleName, String lastName, String suffix, String title,
                                int streetNo, String barangay, String city, int zipCode, 
                                LocalDate birthday, int gwa, LocalDate dateHired, boolean isEmployed);
    public void deletePerson(Integer PersonID);
    public void listPersonsByGWA();
    public void listPersonsByDateHired();
    public void listPersonsByLastName();
}
