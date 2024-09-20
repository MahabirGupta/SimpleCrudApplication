package com.example.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;


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

//    @Query("SELECT c.companyName, COUNT(o) as totalOrders FROM Customer c JOIN Orders o ON c.customerId = o.customerId " +
//            "WHERE o.orderDate BETWEEN :startDate AND :endDate " +
//            "GROUP BY c.companyName ORDER BY totalOrders DESC")
//    List<Object[]> findTopCustomers(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    @Query("SELECT c.companyName, COUNT(o) as totalOrders FROM Customer c JOIN Orders o ON c.customerId = o.customer.customerId WHERE o.orderDate BETWEEN :startDate AND :endDate GROUP BY c.companyName ORDER BY totalOrders DESC")
    List<Object[]> findTopCustomers(Date startDate, Date endDate, Pageable pageable);

}

