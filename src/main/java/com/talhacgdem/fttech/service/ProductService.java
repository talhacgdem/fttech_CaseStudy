package com.talhacgdem.fttech.service;

import com.talhacgdem.fttech.model.Product;
import com.talhacgdem.fttech.model.ProductComment;
import com.talhacgdem.fttech.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCommentService productCommentService;

    public ProductService(ProductRepository productRepository, ProductCommentService productCommentService) {
        this.productRepository = productRepository;
        this.productCommentService = productCommentService;
    }

    public List<Product> getExpiredProducts(){
        Date now = new Date();
        return this.productRepository.findExpiredProducts(now);
    }

    public List<Product> getNotExpiredProducts(){
        Date now = new Date();
        return this.productRepository.findNotExpiredProducts(now);
    }

    public List<ProductComment> getCommentsBetweenTwoDatesForProduct(Integer productId, LocalDateTime date1, LocalDateTime date2){
        return productCommentService.getCommentsBetweenTwoDatesForProduct(productId, date1, date2);
    }

    public List<ProductComment> getCommentsForProduct(Integer productId){
        return productCommentService.getCommentsForProduct(productId);
    }
}
