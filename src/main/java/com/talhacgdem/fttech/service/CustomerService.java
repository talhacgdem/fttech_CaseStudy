package com.talhacgdem.fttech.service;

import com.talhacgdem.fttech.model.ProductComment;
import com.talhacgdem.fttech.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ProductCommentService productCommentService;


    public CustomerService(CustomerRepository customerRepository, ProductCommentService productCommentService) {
        this.customerRepository = customerRepository;
        this.productCommentService = productCommentService;
    }



    public List<ProductComment> getCommentsFromCustomer(Integer customerId){
        return productCommentService.getCommentsFromCustomerId(customerId);
    }

    public List<ProductComment> getCommentsBetweenTwoDatesFromCustomer(Integer customerId, LocalDateTime date1, LocalDateTime date2){
        return productCommentService.getCommentsFromCustomerIdBetweenTwoDates(customerId, date1, date2);
    }
}
