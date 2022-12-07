package com.example.crm_project.Repository;

import com.example.crm_project.Model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
//    SalesRep findSalesRepByNameAndPassword();
//    boolean checkIfUsernameExists();
//
//    void findPasswordByUsername(String userName, String password);

//    boolean checkIfUsernameExists();
//
//    String findPasswordByUsername(String userName, String password);
//
//    SalesRep findSalesRepByNameAndPassword();

   /* List<Object[]> getCountLeadsBySalesRep();

    List<Object[]> getCountOpportunitiesBySalesRep();

    List<Object[]> findCountByStatusClosedWon();

    List<Object[]> findCountByStatusClosedLost();

    List<Object[]> findCountByStatusOpen();*/
}
