package com.example.crm_project.Repository;

import java.util.List;

public interface SalesRepRepository {
    List<Object[]> getCountLeadsBySalesRep();

    List<Object[]> getCountOpportunitiesBySalesRep();

    List<Object[]> findCountByStatusClosedWon();

    List<Object[]> findCountByStatusClosedLost();

    List<Object[]> findCountByStatusOpen();
}
