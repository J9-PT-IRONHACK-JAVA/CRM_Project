package com.example.crm_project.Repository;

import com.example.crm_project.Model.Opportunity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.crm_project.Enums.Product.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
    }

    @Test
    void countOfOpportunitiesByProductTest() {
        var oportunityList = List.of(
                new Opportunity(HYBRID),
                new Opportunity(HYBRID),
                new Opportunity(FLATBED),
                new Opportunity(FLATBED),
                new Opportunity(BOX),
                new Opportunity(BOX)
        );
        opportunityRepository.saveAll(oportunityList);
        var countOfOpportunities = opportunityRepository.countOfOpportunitiesByProduct();
    }
}