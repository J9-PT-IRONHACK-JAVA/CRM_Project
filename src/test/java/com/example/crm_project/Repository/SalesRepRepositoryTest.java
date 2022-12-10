package com.example.crm_project.Repository;

import com.example.crm_project.Enums.Industry;
import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import com.example.crm_project.Model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesRepRepositoryTest {

    SalesRep salesRep;
    Lead lead;
    Lead lead2;
    Lead lead3;
    Opportunity opportunity;
    Opportunity opportunity2;

    Opportunity opportunity3;

    Account account;
    List<Lead> leadList;
    List<Opportunity> opportunityList;
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
        contactList = new ArrayList<>();


        salesRep = salesRepRepository.save(new SalesRep("Pepito", leadList, opportunityList));
        lead = leadRepository.save(new Lead("Adrian", "999888777", "mail@mail.com", "Apple", salesRep));
        lead2 = leadRepository.save(new Lead("Andrés", "999888777", "mail@mail.com", "Apple", salesRep));
        lead3 = leadRepository.save(new Lead("Dani", "999888777", "mail@mail.com", "Apple"));
        contactList.add(Account.newContact(lead));
        account = accountRepository.save(new Account("TiendaPaco",Industry.ECOMMERCE, 200L, "BCN", "ESP", contactList, opportunityList));
        opportunity = opportunityRepository.save(new Opportunity(Product.BOX, 20L, Account.newContact(lead), account,
                salesRep));

        opportunity2 = opportunityRepository.save(new Opportunity(Product.BOX, 30L, Account.newContact(lead), account,
                salesRep));
        opportunity2.setStatus(Status.CLOSED_WON);
        opportunityRepository.save(opportunity2);

        opportunity3 = opportunityRepository.save(new Opportunity(Product.BOX, 40L, Account.newContact(lead), account,
                salesRep));
        opportunity3.setStatus(Status.CLOSED_LOST);
        opportunityRepository.save(opportunity3);
        opportunityList.add(opportunity);
        opportunityList.add(opportunity2);
        opportunityList.add(opportunity3);

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

    /*@Test
    void countLeadsBySalesRep_works() {

        List<Object[]> optionalList = salesRepRepository.countLeadsBySalesRep();
        for (Object[] objects : optionalList) {
            for (Object object : objects) {
                System.out.println(object);
            }
        }
        assertEquals(2L, optionalList.get(0)[1]);
        assertEquals("Pepito", optionalList.get(0)[0]);
    }*/

    @Test
    void countLeadBySaleRep(){

        var result = salesRepRepository.countLeadsBySaleRep("Sara");
        System.out.println(result.get(0)[0]);
    }

    @Test
    void countOpportunitiesBySalesRep_works() {
        List<Object[]> optionalList = salesRepRepository.countOpportunitiesBySalesRep("Sara");
        /*
        assertEquals("Pepito", optionalList.get(0)[0]);
        assertEquals(3L, optionalList.get(0)[1]);*/
    }

    @Test
    void findCountByStatusClosedWon_works() {
        List<Object[]> result = salesRepRepository.findCountByStatusClosedWon("Sara");
        System.out.println(result);
        /*assertEquals("Pepito", optionalList.get(0)[0]);
        assertEquals(1L, optionalList.get(0)[1]);*/
    }

    @Test
    void findCountByStatusClosedLost_works() {
        List<Object[]> optionalList = salesRepRepository.findCountByStatusClosedLost("Dani");
        /*assertEquals("Pepito", optionalList.get(0)[0]);
        assertEquals(1L, optionalList.get(0)[1]);*/
    }

    @Test
    void findCountByStatusOpen_works() {
        List<Object[]> optionalList = salesRepRepository.findCountByOpenStatus("Dani");
        /*assertEquals("Pepito", optionalList.get(0)[0]);
        assertEquals(1L, optionalList.get(0)[1]);*/
    }

    @Test
    void existsByPasswordTest(){
        var result = salesRepRepository.existsByPassword("Dani", "xdani");
        System.out.println(result);
        assertTrue(result);
    }
}