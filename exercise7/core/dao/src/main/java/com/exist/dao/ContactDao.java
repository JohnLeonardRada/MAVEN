package com.exist.dao;

import java.util.Set;

@SuppressWarnings("rawtypes")
public interface ContactDao {
    public void createSessions();
    public Integer addContact(Integer PersonID, Set contacts);
    public void updateContact(Integer ContactID, double landline, double mobileNumber, String email);
    public void deleteContact(Integer ContactID);
}
