package com.example.crm_project.Repository;

import com.example.crm_project.CrmProjectApplication;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {
@MockBean
CrmProjectApplication crmProjectApplication;
    SalesRep salesRep;
    Lead lead;
    Lead lead2;
    Lead lead3;
    Opportunity opportunity;
    Opportunity opportunity2;
    Opportunity opportunity3;
    Opportunity opportunity4;

    Account account;
    Account account2;
    List<Lead> leadList;
    List<Opportunity> opportunityList;
    List<Opportunity> opportunityList2;
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
        contactList = new ArrayList<>();


        salesRep = salesRepRepository.save(new SalesRep("Jaume", leadList, opportunityList));

        lead = leadRepository.save(new Lead("Adrian", "999888777", "mail@mail.com", "Apple", salesRep));
        lead2 = leadRepository.save(new Lead("Andrés", "999888777", "mail@mail.com", "Apple", salesRep));
        lead3 = leadRepository.save(new Lead("Dani", "999888777", "mail@mail.com", "Apple"));

        contactList.add(Account.newContact(lead));

        account = accountRepository.save(new Account("TiendaPaco","ECOMMERCE", 200L, "BCN", "ESP", contactList));
        account2 = accountRepository.save(new Account("TiendaLola",Industry.ECOMMERCE, 400L, "BCN", "FRA", contactList, opportunityList2));

        opportunity = opportunityRepository.save(new Opportunity(Product.BOX, 20L,
                Account.newContact(lead), account, salesRep));
        opportunity2 = opportunityRepository.save(new Opportunity(Product.BOX, 50L,
                Account.newContact(lead),
                account, salesRep));
        opportunity3 = new Opportunity(Product.FLATBED, 30L, Account.newContact(lead), account2, salesRep);
        opportunity3.setStatus(Status.CLOSED_WON);
        opportunityRepository.save(opportunity3);
        opportunity4 = new Opportunity(Product.HYBRID, 80L, Account.newContact(lead), account2,
                salesRep);
        opportunity4.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity4);

//        opportunityList.add(opportunity);
//        opportunityList.add(opportunity2);
//        opportunityList2.add(opportunity3);
//        opportunityList2.add(opportunity4);
        leadList.add(lead);
        leadList.add(lead2);
        leadRepository.saveAll(leadList);

    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
        salesRepRepository.deleteAll();
    }

    @Test
    @DisplayName("Max of employeeCount")
    void meanEmployeeCount() {
        BigDecimal employee = accountRepository.meanEmployeeCount();
        assertEquals(BigDecimal.valueOf(300.0), employee);
    }

    @Test
    @DisplayName("Max of employeeCount")
    void maxEmployeeCount_works() {
        Long employee = accountRepository.maxEmployeeCount();
        assertEquals(400, employee);
    }

    @Test
    @DisplayName("Min of employeeCount")
    void minEmployeeCount_works() {
        Long employee = accountRepository.minEmployeeCount();
        assertEquals(200, employee);
    }

    @Test
    @DisplayName("Median of employeeCount")
    void medianEmployeeCount_works() {
        Long employee = accountRepository.medianEmployeeCount();
//        System.out.println(employee);
        assertEquals(300, employee);
    }

    @Test
    void findAccountByNameTest() {
        var existingAccount = accountRepository.findAccountByCompanyName("TiendaPaco");
        System.out.println("hello");
        assertEquals(existingAccount.isPresent(), true);
    }
}