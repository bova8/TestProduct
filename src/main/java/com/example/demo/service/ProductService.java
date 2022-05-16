package com.example.demo.service;

import com.example.demo.datamodel.Product;
import com.example.demo.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProductService {
    static final Logger logger = Logger.getLogger(ProductService.class.getName());

    public void validate(Product product) {
        if (product.getCode().trim().length() != 13) {
            throw new ValidationException("Invalid Product Code length (" + product + "). It must be 13 symbols!");
        }

        logger.info("Product " + product + " is valid!");
    }
}
