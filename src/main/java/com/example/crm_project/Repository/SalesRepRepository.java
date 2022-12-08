package com.example.crm_project.Repository;

import com.example.crm_project.Model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
    @Query("SELECT sr.name, COUNT(l) FROM SalesRep sr JOIN sr.leads l GROUP BY sr.name")
    List<Object[]> countLeadsBySalesRep();


    @Query("SELECT sr.name, COUNT(o) FROM SalesRep sr JOIN sr.opportunities o GROUP BY sr.name")
    List<Object[]> countOpportunitiesBySalesRep();

    @Query("SELECT sr.name, COUNT(op) FROM SalesRep  sr JOIN sr.opportunities op WHERE op.status = 'CLOSED_WON' GROUP BY sr.name")
    List<Object[]> findCountByStatusClosedWon();

    @Query("SELECT sr.name, COUNT(o) FROM SalesRep  sr JOIN sr.opportunities o WHERE o.status = 'CLOSED_LOST' GROUP BY sr.name")
    List<Object[]> findCountByStatusClosedLost();

    @Query("SELECT sr.name, COUNT(o) FROM SalesRep  sr JOIN sr.opportunities o WHERE o.status = 'OPEN' GROUP BY sr.name")
    List<Object[]> findCountByStatusOpen();

    @Query(value = "SELECT id, rep_name, password FROM sales_reps", nativeQuery = true)
    List<SalesRep> getAllSalesrep();

    @Query("SELECT COUNT(u) > 0 FROM SalesRep u WHERE u.name = :userName")
    boolean existsByUsername(@Param("userName") String userName);

    @Query("SELECT COUNT(u) > 0 FROM SalesRep u WHERE u.password = :password")
    boolean existsByPassword(@Param("password") String password);
}
