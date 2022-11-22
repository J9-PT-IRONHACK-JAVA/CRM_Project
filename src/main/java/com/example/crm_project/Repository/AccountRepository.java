package com.example.crm_project.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {

    List<Object[]> getCountOpportunitiesByIndustry();

    List<Object[]> getCountClosedWonOpportunitiesByIndustry();

    List<Object[]> getCountClosedLostOpportunitiesByIndustry();

    List<Object[]> getCountOpenOpportunitiesByIndustry();

    BigDecimal getAvgEmployeeCount();

    Long getMaxEmployeeCount();

    Long getMinEmployeeCount();

    Long getMedianEmployeeCount();

}
