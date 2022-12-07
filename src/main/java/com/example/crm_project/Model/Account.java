package com.example.crm_project.Model;

import com.example.crm_project.Enums.Industry;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table (name = "accounts")

public class Account {

    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Industry industry;

    private long employeeCount;
    private String city;
    private String country;

//    @ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "account")
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunities = new ArrayList<>();

    //  Constructor => Empty contact list & opportunity list
    public Account(String name, Industry industry, long employeeCount, String city, String country) {
        setName(name);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        contacts = new ArrayList<>();
        opportunities = new ArrayList<>();
    }

    //  Constructor => Adds a contact to contacts list & opportunity to opportunity list
    public Account(String name, Industry industry, long employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setName(name);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        contacts.add(contact);
        opportunities.add(opportunity);
    }

    // Constructor => Uses list of contacts opportunities
    public Account(String name, Industry industry, long employeeCount, String city, String country, List<Contact> contacts, List<Opportunity> opportunities) {
        this.name = name;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
        this.opportunities = opportunities;
    }



//    public void setIndustry(String industry) {
//        industry = industry.toUpperCase();
//        if (industry.equals("PRODUCE")
//            || industry.equals("ECOMMERCE")
//            || industry.equals("MANUFACTURING")
//            || industry.equals("MEDICAL")
//            || industry.equals("OTHER")) {
//            this.industry = Industry.valueOf(industry);
//        } else {
//            throw new IllegalArgumentException("The system doesn't found this industry type. Please enter PRODUCE, " +
//                                               "ECOMMERCE, MANUFACTURING, " +
//                                               "MEDICAL or OTHER");
//        }
//    }

    @Override
    public String toString() {
        return "Account: id = " + getId() + ", industry= " + getIndustry() + ", employeeCount= " + getEmployeeCount() + ", city= " + getCity() + ", country= " + getCountry() +
               "\n Contact List \n" + getContacts() + "\n Opportunity List \n" + getOpportunities();
    }

    public void addContact(Contact newContact) {
        this.contacts.add(newContact);
    }

    public void addOpportunity(Opportunity newOpportunity) {
        this.opportunities.add(newOpportunity);
    }
}
