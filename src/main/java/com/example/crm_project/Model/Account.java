package com.example.crm_project.Model;

import com.example.crm_project.Enums.Industry;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor

public class Account {


    public static final Pattern VALID_PHONENUMBER_REGEX =
            Pattern.compile("\\A[0-9]{3}[0-9]{3}[0-9]{3}\\z", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private Long id;
    private Industry industry;
    private long employeeCount;
    private String city;
    private String country;
    private List<Contact> contacts;
    private List<Opportunity> opportunities;

    //  Constructor => Empty contact list & opportunity list
    public Account(String industry, long employeeCount, String city, String country) {
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        contacts = new ArrayList<>();
        opportunities = new ArrayList<>();
    }

    //  Constructor => Adds a contact to contacts list & opportunity to opportunity list
    public Account(String industry, long employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        contacts.add(contact);
        opportunities.add(opportunity);
    }

    // Constructor => Uses list of contacts opportunities
    public Account(Industry industry, long employeeCount, String city, String country, List<Contact> contacts, List<Opportunity> opportunities) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
        this.opportunities = opportunities;
    }

    public static boolean validatePhone(String phoneStr) {
        Matcher matcher = VALID_PHONENUMBER_REGEX.matcher(phoneStr);
        return matcher.find();
    }

    public static boolean validateEmailAddress(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
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
               "\n Contact List \n" + getContacts() + "\n Opportunity List \n" + getOpportunities();
    }
}
