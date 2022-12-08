package com.example.crm_project.Repository;

import com.example.crm_project.Enums.Industry;
import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import com.example.crm_project.Model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryByIndustryTest {

    SalesRep salesRep;
    Lead lead;
    Lead lead2;
    Lead lead3;

    Opportunity opportunity;
    Opportunity opportunity2;
    Opportunity opportunity3;
    Opportunity opportunity4;
    Opportunity opportunity5;
    Opportunity opportunity6;
    Opportunity opportunity7;
    Opportunity opportunity8;

    Account account;
    Account account2;
    Account account3;
    Account account4;

    List<Lead> leadList;
    List<Opportunity> opportunityList;
    List<Opportunity> opportunityList2;
    List<Opportunity> opportunityList3;
    List<Opportunity> opportunityList4;
    List<Contact> contactList;

    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    LeadRepository leadRepository;
    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        leadList = new ArrayList<>();
        opportunityList = new ArrayList<>();
        opportunityList2 = new ArrayList<>();
        opportunityList3 = new ArrayList<>();
        opportunityList4 = new ArrayList<>();
        contactList = new ArrayList<>();

        account = accountRepository.save(new Account(Industry.ECOMMERCE, 200L, "BCN", "ESP", contactList, opportunityList));
        account2 = accountRepository.save(new Account(Industry.MANUFACTURING, 200L, "BCN", "ESP", contactList, opportunityList2));
        account3 = accountRepository.save(new Account(Industry.MEDICAL, 200L, "BCN", "ESP", contactList, opportunityList3));
        account4 = accountRepository.save(new Account(Industry.OTHER, 200L, "BCN", "FRA", contactList, opportunityList4));
        salesRep = salesRepRepository.save(new SalesRep("Jaume", leadList, opportunityList));
        lead = leadRepository.save(new Lead("Adrian", "999888777", "mail@mail.com", "Apple", salesRep));
        lead2 = leadRepository.save(new Lead("Andrés", "999888777", "mail@mail.com", "Apple", salesRep));
        lead3 = leadRepository.save(new Lead("Dani", "999888777", "mail@mail.com", "Apple"));
        contactList.add(Account.newContact(lead));
        opportunity = opportunityRepository.save(new Opportunity(Product.BOX, 20L,
                Account.newContact(lead),
                account, salesRep));
        opportunity2 = opportunityRepository.save(new Opportunity(Product.BOX, 50L, Account.newContact(lead2), account, salesRep));
        opportunity3 = new Opportunity(Product.FLATBED, 30L, Account.newContact(lead3), account, salesRep);
        opportunity3.setStatus(Status.CLOSED_WON);
        opportunityRepository.save(opportunity3);
        opportunity4 = new Opportunity(Product.HYBRID, 80L, Account.newContact(lead), account2, salesRep);
        opportunity4.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity4);
        opportunity5 = new Opportunity(Product.FLATBED, 30L, Account.newContact(lead2), account3, salesRep);
        opportunity5.setStatus(Status.CLOSED_WON);
        opportunityRepository.save(opportunity5);
        opportunity6 = new Opportunity(Product.HYBRID, 80L, Account.newContact(lead3), account3, salesRep);
        opportunity6.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity6);
        opportunity7 = new Opportunity(Product.HYBRID, 80L, Account.newContact(lead3), account3, salesRep);
        opportunity7.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity7);
        opportunity8 = opportunityRepository.save(new Opportunity(Product.BOX, 50L, Account.newContact(lead3),
                account4, salesRep));
        opportunityList.add(opportunity);
        opportunityList.add(opportunity2);
        opportunityList2.add(opportunity3);
        opportunityList2.add(opportunity4);
        opportunityList3.add(opportunity5);
        opportunityList3.add(opportunity6);
        opportunityList4.add(opportunity7);
        opportunityList4.add(opportunity8);
        leadList.add(lead);
        leadList.add(lead2);
    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
        salesRepRepository.deleteAll();
    }

    @Test
    @DisplayName("Shows count of opportunities by industry")
    void countOpportunitiesByIndustry_works() {
        List<Object[]> optionalList = accountRepository.countOpportunitiesByIndustry();
        assertEquals(3L, optionalList.get(0)[1]);
        assertEquals(1L, optionalList.get(1)[1]);
        assertEquals(Industry.ECOMMERCE, optionalList.get(0)[0]);
    }

    @Test
    @DisplayName("Shows count of all CLOSED_WON Opportunities by industry")
    void countClosedWonOpportunitiesByIndustry_works() {
        List<Object[]> optionalList = accountRepository.countClosedWonOpportunitiesByIndustry();
        assertEquals(Industry.ECOMMERCE, optionalList.get(0)[0]);
        assertEquals(1L, optionalList.get(0)[1]);
        assertEquals(1L, optionalList.get(1)[1]);
    }

    @Test
    @DisplayName("Shows count of all CLOSED_LOST Opportunities by industry")
    void countClosedLostOpportunitiesByIndustry_works() {
        List<Object[]> optionalList = accountRepository.countClosedLostOpportunitiesByIndustry();
        assertEquals(Industry.MANUFACTURING, optionalList.get(0)[0]);
        assertEquals(1L, optionalList.get(0)[1]);
        assertEquals(2L, optionalList.get(1)[1]);
    }

    @Test
    @DisplayName("Shows count of all OPEN Opportunities by industry")
    void countOpenOpportunitiesByIndustry_works() {
        List<Object[]> optionalList = accountRepository.countOpenOpportunitiesByIndustry();
        assertEquals(Industry.OTHER, optionalList.get(1)[0]);
        assertEquals(2L, optionalList.get(0)[1]);
        assertEquals(1L, optionalList.get(1)[1]);
    }
}