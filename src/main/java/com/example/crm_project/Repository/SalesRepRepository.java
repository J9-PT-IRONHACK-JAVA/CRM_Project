package com.example.crm_project.Repository;

import com.example.crm_project.Model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
    @Query("SELECT sr.name, COUNT(l) FROM SalesRep sr JOIN sr.leads l WHERE sr.name = ?1")
    List<Object[]> countLeadsBySaleRep(String string);


    @Query("SELECT sr.name, COUNT(o) FROM SalesRep sr JOIN sr.opportunities o WHERE sr.name = ?1")
    List<Object[]> countOpportunitiesBySalesRep(String string);

    @Query("SELECT sr.name, COUNT(op) FROM SalesRep  sr JOIN sr.opportunities op WHERE op.status = 'CLOSED_WON' AND sr.name = ?1")
    List<Object[]> findCountByStatusClosedWon(String string);

    @Query("SELECT sr.name, COUNT(o) FROM SalesRep  sr JOIN sr.opportunities o WHERE o.status = 'CLOSED_LOST' AND sr.name = ?1")
    List<Object[]> findCountByStatusClosedLost(String string);

    @Query("SELECT sr.name, COUNT(o) FROM SalesRep  sr JOIN sr.opportunities o WHERE o.status = 'OPEN' AND sr.name = ?1")
    List<Object[]> findCountByOpenStatus(String string);

    @Query(value = "SELECT id, rep_name, password FROM sales_reps", nativeQuery = true)
    List<SalesRep> getAllSalesrep();

    @Query("SELECT COUNT(u) > 0 FROM SalesRep u WHERE u.name = :userName")
    boolean existsByUsername(@Param("userName") String userName);

    //@Query("SELECT COUNT(u) > 0 FROM SalesRep u WHERE u.password = :password")
    @Query("SELECT COUNT(u) > 0 FROM SalesRep u WHERE u.name = ?1 AND u.password = ?2")
    boolean existsByPassword(String userName, String password);
    //"SELECT COUNT(u) > 0 FROM SalesRep u WHERE u.name = ?1 AND u.password = ?2"

    @Query("FROM SalesRep s WHERE s.name = ?1")
    SalesRep getSalesRepByName(String name);
}
