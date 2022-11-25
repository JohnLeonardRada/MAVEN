package com.exist.service;

import java.time.LocalDate;
import java.util.HashSet;

import javax.persistence.NoResultException;

import com.exist.model.Contact;
import com.exist.model.Role;
import com.exist.service.utility.Reader;

public class MainController {
    public void actionMenu(){
        int action;
        action = Reader.readInt("What's your action?");

        if(action == 1){
            addPerson();
        }else if(action == 2){
            updatePerson();
        }else if(action == 3){
            deletePerson();
        }else if(action == 4){
            listPersons();
        }else if(action == 5){
            addContact();
        }else if(action == 6){
            updateContact();
        }else if(action == 7){
            deleteContact();
        }else if(action == 8){
            addRoleToPerson();
        }else if(action == 9){
            deleteRoleFromPerson();
        }else if(action == 10){
            addRole();
        }else if(action == 11){
            updateRole();
        }else if(action == 12){
            deleteRole();
        }else if(action == 13){
            listRole();
        }else if(action == 0){
            System.exit(0);
        }
        actionMenu();
    }

    ManagePerson mp = new ManagePerson();
    ManageContact mc = new ManageContact();
    ManageRole mr = new ManageRole();

    public void addPerson(){
        mp.createSessions();
        String firstName = Reader.readString("Enter First Name");
        String middleName = Reader.readString("Enter Middle Name");
        String lastName = Reader.readString("Enter Last Name");
        String suffix = Reader.readString("Enter Suffix");
        String title = Reader.readString("Enter Title");
        int streetNo = Reader.readInt("Enter Street No.");
        String barangay = Reader.readString("Enter barangay");
        String city = Reader.readString("Enter city");
        int zipCode = Reader.readInt("Enter Zip Code");

        System.out.println("Enter Birthday");
        LocalDate birthday = Reader.readLocalDate("");

        int gwa = Reader.readInt("Enter GWA");
        System.out.println("Enter Date Hired");
        LocalDate dateHired = Reader.readLocalDate("");
        boolean isEmployed = Reader.readBoolean("Is Currently Employed?");
        mp.addPerson(firstName, middleName, lastName, suffix, title, streetNo, barangay, city, zipCode, birthday, gwa, dateHired, isEmployed);
        // mp.addPerson("John", "Leonard", "Rada", "Emgr.", "Intern", 123, "Barangay 133", "Caloocan City", 1400, "June 5", 1, "August 23");
    }

    public void updatePerson(){
        mp.createSessions();
        int PersonID = Reader.readInt("Enter Person ID");
        
        String firstName = Reader.readString("Enter First Name");
        String middleName = Reader.readString("Enter Middle Name");
        String lastName = Reader.readString("Enter Last Name");
        String suffix = Reader.readString("Enter Suffix");
        String title = Reader.readString("Enter Title");
        int streetNo = Reader.readInt("Enter Street No.");
        String barangay = Reader.readString("Enter barangay");
        String city = Reader.readString("Enter city");
        int zipCode = Reader.readInt("Enter Zip Code");

        System.out.println("Enter Birthday");
        LocalDate birthday = Reader.readLocalDate("");

        int gwa = Reader.readInt("Enter GWA");
        System.out.println("Enter Date Hired");
        LocalDate dateHired = Reader.readLocalDate("");
        boolean isEmployed = Reader.readBoolean("Is Currently Employed?");
        mp.updatePerson(PersonID, firstName, middleName, lastName, suffix, title, streetNo, barangay, city, zipCode, birthday, gwa, dateHired, isEmployed);
        //mp.updatePerson(43 ,"Snoopy", "Boi", "Flyer", "Engr.", "Intern", 123, "Barangay Galaxy", "SuperNova City", 1400, "December XXXX", 1, "January ZZZZ");
    }

    public void deletePerson(){
        mp.createSessions();
        int PersonID = Reader.readInt("Enter Person ID");
        mp.deletePerson(PersonID);
    }

    public void listPersons(){
        mp.createSessions();

        int choice = Reader.readInt("Enter Choice");

        if(choice == 1){
            mp.listPersonsByGWA();
        }else if (choice == 2){
            mp.listPersonsByDateHired();
        }else if(choice == 3){
            mp.listPersonsByLastName();
        }else{
            System.out.println("Invalid Input!");
            listPersons();
        }
    }

    public void addContact(){
        mc.createSessions();

        int PersonID = Reader.readInt("Enter Person ID");
        double landline = Reader.readDouble("Enter Landline");
        double mobileNumber = Reader.readDouble("Enter Mobile Number");
        String email = Reader.readString("Enter Email");

        HashSet<Contact> set1 = new HashSet<>();
        set1.add(new Contact(landline, mobileNumber, email));
        
        mc.addContact(PersonID, set1);
    }

    public void updateContact(){
        mc.createSessions();

        int ContactID = Reader.readInt("Enter Contact ID");
        double landline = Reader.readDouble("Enter Landline");
        double mobileNumber = Reader.readDouble("Enter Mobile Number");
        String email = Reader.readString("Enter Email");

        mc.updateContact(ContactID, landline, mobileNumber, email);
    }

    public void deleteContact(){
        mc.createSessions();

        int ContactID = Reader.readInt("Enter Contact ID");

        mc.deleteContact(ContactID);
    }

    public void addRoleToPerson(){
        mr.createSessions();

        int PersonID = Reader.readInt("Enter Person ID");
        try {
            String roleName = Reader.readString("Enter Role Name");

            HashSet<Role> set1 = new HashSet<>();
            set1.add(new Role(roleName));

            mr.addRoleToPerson(PersonID, set1);
        } catch (NoResultException e) {
            System.err.println(e);
        }
    }

    public void deleteRoleFromPerson(){
        mr.createSessions();
       
        int PersonID = Reader.readInt("Enter Person ID");
        int RoleID = Reader.readInt("Enter Role ID");

        mr.deleteRoleFromPerson(PersonID, RoleID);
    }

    public void addRole(){
        mr.createSessions();

        String roleName = Reader.readString("Enter Role Name");
        mr.addRole(roleName);
    }

    public void updateRole(){
        mr.createSessions();

        int RoleID = Reader.readInt("Enter Role ID");
        String roleName = Reader.readString("Enter Role Name");

        mr.updateRole(RoleID, roleName);
    }

    public void deleteRole(){
        mr.createSessions();
        
        int RoleID = Reader.readInt("Enter Role ID");

        mr.deleteRole(RoleID);
    }

    public void listRole(){
        mr.createSessions();
        mr.listRoles();
    }

}
