package com.example.crm_project.Repository;

import com.example.crm_project.Model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    // * by Product
    //The mean quantity of products order can be displayed
    // ! Every method exposed here, needs to start with a @Query("query from SQL like we did on class in workbench")
    Double getAvgQuantityOfProducts();

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
    Double getMedianOpportunitiesAccount();
}
