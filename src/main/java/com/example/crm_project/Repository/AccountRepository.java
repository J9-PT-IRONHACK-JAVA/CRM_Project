package com.example.crm_project.Repository;

import com.example.crm_project.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
//@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
/*
    List<Object[]> findCountOpportunitiesByIndustry();

    List<Object[]> getCountClosedWonOpportunitiesByIndustry();

    List<Object[]> getCountClosedLostOpportunitiesByIndustry();

    List<Object[]> getCountOpenOpportunitiesByIndustry();

    BigDecimal getAvgEmployeeCount();

    Long getMaxEmployeeCount();

    Long getMinEmployeeCount();

    Long getMedianEmployeeCount();*/

}
