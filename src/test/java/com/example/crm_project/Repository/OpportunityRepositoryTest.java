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

    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void countOfOpportunitiesByProductTest() {
        var result = opportunityRepository.countOfOpportunitiesByProduct();
        System.out.println(result);
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
    //BY country
    @Test
    void countOppByCountryTest(){

        var result = opportunityRepository.countOppByCountry();
        System.out.println(result);
        /*var actualOpp = result.get(0)[0];
        var actualOpp2 = result.get(1)[0];
        var actualOpp3 = result.get(2)[0];

        assertEquals("UK", actualOpp);
        assertEquals("Germany", actualOpp2);
        assertEquals("España", actualOpp3);*/
    }
    @Test
    void countClosedWonOppByCountryTest(){

        var result = opportunityRepository.countClosedWonOppByCountry();
        System.out.println(result);
        var actual = result.get(0)[0];
        Long l2 = Long.valueOf(1);
        assertEquals(l2, actual);
    };

    @Test
    void countClosedLostOppByCountryTest(){

        var result = opportunityRepository.countClosedLostOppByCountry();
        var actual = result.get(0)[1];
        assertEquals("Germany", actual);
    };

    @Test
    void countOpenOppByCountryTest(){

        var result = opportunityRepository.countOpenOppByCountry();
        var actual = result.get(0)[1];
        System.out.println(actual);
        assertEquals("UK", actual);
    }

    @Test
    void countAvgOfProductsTest(){
        var result = opportunityRepository.countAvgOfProducts();
        System.out.println(result);
        var actual = result.get(0)[0];
        assertEquals(2.75, actual);
    }

    @Test
    void countMinOfProductsTest(){
        var result = opportunityRepository.countMinOfProducts();
        var actual = result.get(0)[1];
        System.out.println(result);
        Long l2 = Long.valueOf(2);
        assertEquals(l2, actual);
    }

    @Test
    void countMaxOfProductsTest(){
        var result = opportunityRepository.countMaxOfProducts();
        var actual = result.get(0)[1];
        Long l2 = Long.valueOf(3);
        System.out.println(result);
        assertEquals(l2, actual);
    }

}