package com.example.crm_project.utils;

import com.example.crm_project.Model.Account;
import com.example.crm_project.Model.Contact;
import com.example.crm_project.Model.Opportunity;
import com.example.crm_project.Model.SalesRep;
import com.example.crm_project.Repository.AccountRepository;
import com.example.crm_project.Repository.OpportunityRepository;
import com.example.crm_project.Repository.SalesRepRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.example.crm_project.Enums.Product.*;
import static com.example.crm_project.Enums.Product.FLATBED;
import static com.example.crm_project.Enums.Status.*;

@Configuration
@RequiredArgsConstructor
public class DataLoader {

    private final OpportunityRepository opportunityRepository;
    private final AccountRepository accountRepository;
    private final SalesRepRepository salesRepRepository;

    @Bean
    void loadDataToOppRepository(){
        //var contact = new Contact( "Dani", 633223530, "daniRoman@gmail.com","Juanazo&Co");
        var contact = new Contact( "MArtina", "633223530", "daniRoman@gmail.com","Juanazo&Co");
        var acount = new Account("Medical", 20, "London", "UK");
        var sales = new SalesRep("Sara", "xsara");

        var contact2 = new Contact( "Juan", "623227535", "juan@gmail.com","LaCalaver");
        var acount2 = new Account("produce", 300, "Berlin", "Germany");
        var sales2 = new SalesRep("Adri", "xadri");

        var contact3 = new Contact( "JAcob", "636666530", "ivan@gmail.com","Interco");
        var acount3 = new Account("ecommerce", 30, "islaTypi", "Isla feroe");
        var sales3 = new SalesRep("Andres", "xandres");

        var contact4 = new Contact( "Martin", "656666530", "martin@gmail.com","LaSalle");
        var acount4 = new Account("ecommerce", 100, "Barcelona", "España");
        var sales4 = new SalesRep("Dani", "xdani");

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
}
