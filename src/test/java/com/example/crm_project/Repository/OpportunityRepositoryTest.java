package com.example.crm_project.Repository;

import com.example.crm_project.Enums.Industry;
import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import com.example.crm_project.Model.Account;
import com.example.crm_project.Model.Contact;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Model.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.crm_project.Enums.Industry.MEDICAL;
import static com.example.crm_project.Enums.Product.*;
import static com.example.crm_project.Enums.Status.OPEN;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {

        //var contact = new Contact( "Dani", 633223530, "daniRoman@gmail.com","Juanazo&Co");


    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void countOfOpportunitiesByProductTest() {
        var contact = new Contact( "Dani", 633223530, "daniRoman@gmail.com","Juanazo&Co");
        var acount = new Account("Medical", 20, "London", "UK");
        var sales = new SalesRep("Sara");

        accountRepository.save(acount);
        salesRepRepository.save(sales);


        var oportunityList = List.of(
                new Opportunity(HYBRID, 2, contact, OPEN, acount, sales),
                new Opportunity(FLATBED, 3, contact, OPEN, acount, sales),
                new Opportunity(BOX, 3, contact, OPEN, acount, sales)
        );
        opportunityRepository.saveAll(oportunityList);
        var countOfOpportunities = opportunityRepository.countOfOpportunitiesByProduct();
        System.out.println(countOfOpportunities);
    }
}