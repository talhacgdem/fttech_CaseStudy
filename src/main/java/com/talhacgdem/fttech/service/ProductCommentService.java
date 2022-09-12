package com.talhacgdem.fttech.service;

import com.talhacgdem.fttech.model.ProductComment;
import com.talhacgdem.fttech.repository.ProductCommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductCommentService {
    private final ProductCommentRepository productCommentRepository;

    public ProductCommentService(ProductCommentRepository productCommentRepository) {
        this.productCommentRepository = productCommentRepository;
    }

    public List<ProductComment> getCommentsFromCustomerId(Integer customerId){
        return productCommentRepository.findByCustomer(customerId);
    }

    public List<ProductComment> getCommentsFromCustomerIdBetweenTwoDates(Integer customerId, LocalDateTime date1, LocalDateTime date2){
        return productCommentRepository.findByCustomerByDateDateBetween(customerId, date1, date2);
    }

    public List<ProductComment> getCommentsBetweenTwoDatesForProduct(Integer productId, LocalDateTime date1, LocalDateTime date2){
        return productCommentRepository.getCommentsBetweenTwoDatesForProduct(productId, date1, date2);
    }

    public List<ProductComment> getCommentsForProduct(Integer productId){
        return productCommentRepository.findByProduct(productId);
    }
}
