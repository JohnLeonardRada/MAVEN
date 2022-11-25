package com.exist.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Person implements Serializable{
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String title;
    private int streetNo;
    private String barangay;
    private String city;
    private int zipCode;
    private LocalDate birthday;
    private int gwa;
    private LocalDate dateHired;
    private boolean employed;
    private Set contacts;
    private Set roles;

    public Person(){}

    public Person(String firstName, String middleName, String lastName, String suffix, String title,
                    int streetNo, String barangay, String city, int zipCode, 
                    LocalDate birthday, int gwa, LocalDate dateHired, boolean employed){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.title = title;
        this.streetNo = streetNo;
        this.barangay = barangay;
        this.city = city;
        this.zipCode = zipCode;
        this.birthday = birthday;
        this.gwa = gwa;
        this.dateHired = dateHired;
        this.employed = employed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getGwa() {
        return gwa;
    }

    public void setGwa(int gwa) {
        this.gwa = gwa;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }

    public boolean getEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public Set getContacts() {
        return contacts;
    }

    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

}
