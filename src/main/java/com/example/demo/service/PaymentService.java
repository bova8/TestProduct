package com.example.demo.service;

import com.example.demo.datamodel.Payment;
import com.example.demo.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PaymentService {
    static final Logger logger = Logger.getLogger(PaymentService.class.getName());

    private ProductService productService;

    public PaymentService(ProductService productService) {
        this.productService = productService;
    }

    public void validate(Payment payment) {
        if (payment.getProducts().isEmpty()) {
            throw new ValidationException("Empty products!");
        }

        if (payment.getSeller().trim().length() != 9) {
            throw new ValidationException("Invalid Seller length. It must be 9 symbols!");
        }

        if (payment.getCustomer().trim().length() != 9) {
            throw new ValidationException("Invalid Customer length. It must be 9 symbols!");
        }

        payment.getProducts().forEach(productService::validate);

        logger.info("Payment " + payment + " is valid!");
    }
}
