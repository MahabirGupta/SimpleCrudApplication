package com.example.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private CustomerService customerService;

//    @GetMapping("/top-customers")
//    public String showTopCustomers(
//            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
//            Model model) {
//
//        // Check if parameters are being passed correctly
//        System.out.println("Start Date: " + startDate);
//        System.out.println("End Date: " + endDate);
//
//        List<Object[]> results = customerService.getTopCustomers(startDate, endDate);
//        model.addAttribute("results", results);
//        return "top-customers"; // Renders top-customers.html
//    }

//    @GetMapping("/top-customers")
//    public String showTopCustomers(
//            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
//            Model model) {
//
//        // Logging for debug
//        System.out.println("Start Date: " + startDate);
//        System.out.println("End Date: " + endDate);
//
//        List<Object[]> results = customerService.getTopCustomers(startDate, endDate);
//        model.addAttribute("results", results);
//        return "top-customers";
//    }
//@GetMapping("/top-customers")
//public String showTopCustomers(
//        @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//        @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
//        Model model) {
//
//    // Handle cases where startDate or endDate might be null
//    if (startDate == null || endDate == null) {
//        model.addAttribute("error", "Please provide both startDate and endDate.");
//        return "top-customers"; // Return the same view with an error message
//    }
//
//    List<Object[]> results = customerService.getTopCustomers(startDate, endDate);
//    model.addAttribute("results", results);
//    return "top-customers";
//}

    @GetMapping("/top-customers")
    public String showTopCustomers(
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate,
            Model model) {

        List<Object[]> results = customerService.getTopCustomers(startDate, endDate);
        model.addAttribute("results", results);
        return "top-customers";
    }


}
