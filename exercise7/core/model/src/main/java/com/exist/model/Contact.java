package com.exist.model;

import java.util.Set;

@SuppressWarnings("rawtypes")
public class Contact {
    private int id;
    private double landline;
    private double mobileNumber;
    private String email;
    private Set contacts;

    public Contact(){}

    public Contact(double landline, double mobileNumber, String email){
        this.landline = landline;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLandline() {
        return landline;
    }

    public void setLandline(double landline) {
        this.landline = landline;
    }

    public double getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(double mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set getContacts() {
        return contacts;
    }

    public void setContacts(Set contacts) {
        this.contacts = contacts;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;

        Contact obj2 = (Contact)obj;
        if((this.id == obj2.getId()) && (this.landline == (obj2.getLandline())) &&
            this.mobileNumber == (obj2.getMobileNumber()) && this.email.equals(obj2.getEmail())) {
            return true;
        }
        return false;
    }
     
    public int hashCode() {
        int tmp = 0;
        tmp = (id + landline + mobileNumber + email).hashCode();
        return tmp;
    }
    
}
