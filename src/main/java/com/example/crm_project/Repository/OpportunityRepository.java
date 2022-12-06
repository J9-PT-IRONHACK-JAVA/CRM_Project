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


    // * by Product
    //The mean quantity of products order can be displayed
    // ! Every method exposed here, needs to start with a @Query("query from SQL like we did on class in workbench")
    /*Double getAvgQuantityOfProducts();

    //The median quantity of products order
    Double getMedianQuantityOfProducts();

    //A count of all Opportunities by the product
    List<Object[]> findCountByProduct();

    //The maximum quantity of products order
    Long getMaxQuantityOfProducts();

    //The minimum quantity of products order
    Long getMinQuantityOfProducts();

    //Opportunities by CITY
    List<Object[]> getCountOpportunitiesByCity();

    List<Object[]> getCountClosedWonOpportunitiesByCity();

    List<Object[]> getCountClosedLostOpportunitiesByCity();

    List<Object[]> getCountOpenOpportunitiesByCity();

    //Opportunities by COUNTRY
    List<Object[]> getCountOpportunitiesByCountry();

    List<Object[]> getCountOpportunitiesByCountryWhereStatusLikeOpen();

    List<Object[]> getCountOpportunitiesByCountryWhereStatusLikeWon();

    List<Object[]> getCountOpportunitiesByCountryWhereStatusLikeLost();

    //Opportunities by PRODUCT
    List<Object[]> getCountOpportunitiesByProduct();

    List<Object[]> getCountOpportunitiesByProductWhereStatusLikeOpen();

    List<Object[]> getCountOpportunitiesByProductWhereStatusLikeWon();

    List<Object[]> getCountOpportunitiesByProductWhereStatusLikeLost();

    //Average number of Opportunities associated with an Account
    Double getAvgOpportunitiesAccount();

    //maximum number of Opportunities associated with an Account
    Long getMaxOpportunitiesAccount();

    //minimum number of Opportunities associated with an Account
    Long getMinOpportunitiesAccount();

    //median number of Opportunities associated with an Account
    Double getMedianOpportunitiesAccount();*/
}
