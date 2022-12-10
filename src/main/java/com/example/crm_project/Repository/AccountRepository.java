package com.example.crm_project.Repository;

import com.example.crm_project.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // A count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunities o GROUP BY a.city")
    List<Object[]> countOpportunitiesByCity();

    // A count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunities o WHERE o.status = 'CLOSED_WON' GROUP BY a.city")
    List<Object[]> countClosedWonOpportunitiesByCity();

    // A count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunities o WHERE o.status = 'CLOSED_LOST' GROUP BY a.city")
    List<Object[]> countClosedLostOpportunitiesByCity();

    // A count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
    @Query("SELECT a.city, count(o) FROM Account a JOIN a.opportunities o WHERE o.status = 'OPEN' GROUP BY a.city")
    List<Object[]> countOpenOpportunitiesByCity();
    @Query("SELECT a.industry, count(o) FROM Account a JOIN a.opportunities o GROUP BY a.industry")
    List<Object[]> countOpportunitiesByIndustry();

    // A count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
    @Query("SELECT a.industry, count(o) FROM Account a JOIN a.opportunities o WHERE o.status = 'CLOSED_WON' GROUP BY a.industry")
    List<Object[]> countClosedWonOpportunitiesByIndustry();

    // A count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
    @Query("SELECT a.industry, count(o) FROM Account a JOIN a.opportunities o WHERE o.status = 'CLOSED_LOST' GROUP BY a.industry")
    List<Object[]> countClosedLostOpportunitiesByIndustry();

    // A count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
    @Query("SELECT a.industry, count(o) FROM Account a JOIN a.opportunities o WHERE o.status = 'OPEN' GROUP BY a.industry")
    List<Object[]> countOpenOpportunitiesByIndustry();


    //The mean employeeCount can be displayed by typing “Mean EmployeeCount”
    @Query("SELECT AVG(employeeCount) FROM Account")
    BigDecimal meanEmployeeCount();

    //The maximum employeeCount can be displayed by typing “Max EmployeeCount”
    @Query("SELECT MAX(employeeCount) FROM Account")
    Long maxEmployeeCount();

    //The minimum employeeCount can be displayed by typing “Min EmployeeCount”
    @Query("SELECT MIN(employeeCount) FROM Account")
    Long minEmployeeCount();

    //The median employeeCount can be displayed by typing “Median EmployeeCount”
    @Query("SELECT AVG(a.employeeCount) FROM Account a")
    Long medianEmployeeCount();
    @Query("FROM Account a WHERE a.companyName = ?1")
    Optional<Account> findAccountByCompanyName(String companyName);
}
