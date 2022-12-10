package com.example.crm_project.Model;

import com.example.crm_project.Enums.Industry;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "accounts")
@ToString(
        exclude = "opportunities")

public class Account {

    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    @Enumerated(EnumType.STRING)
    private Industry industry;

    private long employeeCount;
    private String city;
    private String country;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunities = new ArrayList<>();

    //  Constructor => Empty contact list & opportunity list
    public Account(String companyName, String industry, long employeeCount, String city, String country) {
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        contacts = new ArrayList<>();
        opportunities = new ArrayList<>();
    }

    public Account(String companyName, String industry, long employeeCount, String city, String country, List<Contact> contacts) {
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setContacts(contacts);
    }

    //  Constructor => Adds a contact to contacts list & opportunity to opportunity list
    public Account(String companyName, String industry, long employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        contacts.add(contact);
        opportunities.add(opportunity);
    }

    // Constructor => Uses list of contacts opportunities
    public Account(String companyName, Industry industry, long employeeCount, String city, String country, List<Contact> contacts, List<Opportunity> opportunities) {
        setCompanyName(companyName);
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
        this.opportunities = opportunities;
    }

    public void setIndustry(String industry) {
        industry = industry.toUpperCase();
        if (industry.equals("PRODUCE")
            || industry.equals("ECOMMERCE")
            || industry.equals("MANUFACTURING")
            || industry.equals("MEDICAL")
            || industry.equals("OTHER")) {
            this.industry = Industry.valueOf(industry);
        } else {
            throw new IllegalArgumentException("The system doesn't found this industry type. Please enter PRODUCE, " +
                                               "ECOMMERCE, MANUFACTURING, " +
                                               "MEDICAL or OTHER");
        }
    }

    @Override
    public String toString() {
        return "Account: id = " + getId() + ", industry= " + getIndustry() + ", employeeCount= " + getEmployeeCount() + ", city= " + getCity() + ", country= " + getCountry() +
               "\n Contact List \n" + getContacts();
    }


    public static Contact newContact(Lead lead) {
        Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        System.out.println("Lead converted into a new contact: ");
        System.out.println(contact);
        return contact;
    }

    public void addContact(Contact newContact) {
        this.contacts.add(newContact);
    }

    public void addOpportunity(Opportunity newOpportunity) {
        this.opportunities.add(newOpportunity);
    }
}
