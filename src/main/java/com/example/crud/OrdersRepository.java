package com.example.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

//    @Query("SELECT c.contactName, COUNT(o) " +
//            "FROM Orders o JOIN o.customer c " +
//            "GROUP BY c.contactName")
//    List<Object[]> findCustomerContactNamesWithOrderCount();
@Query("SELECT c.contactName, COUNT(o) " +
        "FROM Orders o JOIN o.customer c " +
        "WHERE o.orderDate BETWEEN :startDate AND :endDate " +
        "GROUP BY c.contactName")
List<Object[]> findCustomerOrderCountByYear(Date startDate, Date endDate);
}
