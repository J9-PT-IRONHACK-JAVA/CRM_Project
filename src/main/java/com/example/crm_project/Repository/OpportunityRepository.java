package com.example.crm_project.Repository;

import com.example.crm_project.Enums.Product;
import com.example.crm_project.Model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    //A count of all Opportunities by the product can be displayed by typing “Report Opportunity by the product”
    @Query("SELECT a.product, COUNT(a) AS cont FROM Opportunity a GROUP BY a.product ")
    List<Object[]>countOfOpportunitiesByProduct();

    /*
    * A count of all CLOSED_WON, CLOSED_LOST, OPEN Opportunities by the product can be displayed
    * by typing “Report CLOSED-WON by the product”
    * */
    @Query("SELECT COUNT(a), a.product FROM Opportunity a WHERE a.status = 'CLOSED_WON' GROUP BY a.product")
    List<Object[]>countClosedWonOppByProduct(); //Acceding into it by  result.get(index)[subindex]
    //List<List<Object>>Acceding into it by acceding into it by result.get().get()

    @Query("SELECT COUNT(a), a.product FROM Opportunity a WHERE a.status = 'CLOSED_LOST' GROUP BY a.product")
    List<Object[]>countClosedLostOppByProduct();

    @Query("SELECT COUNT(a), a.product FROM Opportunity a WHERE a.status = 'OPEN' GROUP BY a.product ")
    List<Object[]>countOpenOppByProduct();
    //By Country
    //A count of all Opportunities by country can be displayed by typing “Report Opportunity by Country”
    @Query("SELECT a.country, COUNT(o) FROM Opportunity o JOIN Account a ON o.account.id = a.id GROUP BY a.country" )
    List<Object[]>countOppByCountry();

    //count of all CLOSED_WON Opportunities by country can be displayed by typing “Report CLOSED-WON by Country”
    @Query("SELECT COUNT( o ) AS CLOSED_WON_COUNT ,a.country FROM Opportunity o JOIN Account a ON o.account.id = a.id WHERE o.status = 'CLOSED_WON' GROUP BY a.country" )
    List<Object[]>countClosedWonOppByCountry();

    //A count of all CLOSED_LOST Opportunities by country can be displayed by typing “Report CLOSED-LOST by Country”
    @Query("SELECT COUNT( o ) AS CLOSED_LOST_COUNT ,a.country FROM Opportunity o JOIN Account a ON o.account.id = a.id WHERE o.status = 'CLOSED_LOST' GROUP BY a.country" )
    List<Object[]>countClosedLostOppByCountry();

    //A count of all OPEN Opportunities by country can be displayed by typing “Report OPEN by Country”
    @Query("SELECT COUNT( o ) AS OPEN_COUNT ,a.country FROM Opportunity o JOIN Account a ON o.account.id = a.id WHERE o.status = 'OPEN' GROUP BY a.country" )
    List<Object[]>countOpenOppByCountry();

    //Quantity States
    //The median quantity of products order can be displayed by typing “Median Quantity”
    @Query("SELECT AVG(quantity) FROM Opportunity")
    List<Object[]> countAvgOfProducts();
    //The maximum quantity of products order can be displayed by typing “Max Quantity”
    @Query("SELECT product, quantity FROM Opportunity WHERE quantity = (SELECT MAX(quantity) FROM Opportunity )")
    List<Object[]> countMaxOfProducts();
    //The minimum quantity of products order can be displayed by typing “Min Quantity”
    @Query("SELECT product, quantity FROM Opportunity WHERE quantity = (SELECT MIN(quantity) FROM Opportunity)")
    List<Object[]> countMinOfProducts();

}
