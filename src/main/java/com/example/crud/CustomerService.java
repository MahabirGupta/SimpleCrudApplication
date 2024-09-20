package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Object[]> getTopCustomers(Date startDate, Date endDate) {
        Pageable topTen = PageRequest.of(0, 10);
        return ordersRepository.findTopCustomers(startDate, endDate, topTen);
    }
}
