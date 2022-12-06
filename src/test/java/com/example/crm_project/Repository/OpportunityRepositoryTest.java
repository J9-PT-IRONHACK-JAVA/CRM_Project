package com.example.crm_project.Repository;

import com.example.crm_project.Enums.Industry;
import com.example.crm_project.Enums.Product;
import com.example.crm_project.Enums.Status;
import com.example.crm_project.Model.Account;
import com.example.crm_project.Model.Contact;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Model.SalesRep;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static com.example.crm_project.Enums.Industry.MEDICAL;
import static com.example.crm_project.Enums.Product.*;
import static com.example.crm_project.Enums.Status.*;
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
        var contact = new Contact( "MArtina", "633223530", "daniRoman@gmail.com","Juanazo&Co");
        var acount = new Account("Medical", 20, "London", "UK");
        var sales = new SalesRep("Sara");

        var contact2 = new Contact( "Juan", "623227535", "juan@gmail.com","LaCalaver");
        var acount2 = new Account("produce", 300, "Berlin", "Germany");
        var sales2 = new SalesRep("Adri");

        var contact3 = new Contact( "JAcob", "636666530", "ivan@gmail.com","Interco");
        var acount3 = new Account("ecommerce", 30, "islaTypi", "Isla feroe");
        var sales3 = new SalesRep("Andres");

        var contact4 = new Contact( "Martin", "656666530", "martin@gmail.com","LaSalle");
        var acount4 = new Account("ecommerce", 100, "Barcelona", "España");
        var sales4 = new SalesRep("Dani");

        accountRepository.save(acount);
        accountRepository.save(acount2);
        accountRepository.save(acount3);
        accountRepository.save(acount4);
        salesRepRepository.save(sales);
        salesRepRepository.save(sales2);
        salesRepRepository.save(sales3);
        salesRepRepository.save(sales4);


        var oportunityList = List.of(
                new Opportunity(HYBRID, 2, contact, OPEN, acount, sales),
                new Opportunity(FLATBED, 3, contact2, CLOSED_LOST, acount2, sales4),
                new Opportunity(BOX, 3, contact3, OPEN, acount4, sales4),
                new Opportunity(FLATBED, 3, contact4, CLOSED_WON, acount4, sales4)
        );
        opportunityRepository.saveAll(oportunityList);


    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void countOfOpportunitiesByProductTest() {
        var contact = new Contact( "Dani", 633223530, "daniRoman@gmail.com","Juanazo&Co");
        var acount = new Account("Medical", 20, "London", "UK");
        var sales = new SalesRep("Sara", "amoAMiPerro89");

        var result = opportunityRepository.countOfOpportunitiesByProduct();
        var actual = result.get(1)[1];
        Long l2 = Long.valueOf(2);
        assertEquals(l2, actual);
    }
    @Test
    void countClosedWonOppByProductTest(){
        var result = opportunityRepository.countClosedWonOppByProduct();
        var actual = result.get(0)[0];
        Long l2 = Long.valueOf(2);
        //assertEquals(l2, actual);
        System.out.println(result);
    }

    @Test
    void countClosedLostOppByProductTest(){
        var result = opportunityRepository.countClosedLostOppByProduct();
        var actual = result.get(0)[0];
        Long l2 = Long.valueOf(1);
        assertEquals(l2, actual);
    }

    @Test
    void countOpenOppByProductTest(){
        var result = opportunityRepository.countOpenOppByProduct();
        var actual = result.get(0)[0];
        Long l2 = Long.valueOf(1);
        assertEquals(l2, actual);
    }



}