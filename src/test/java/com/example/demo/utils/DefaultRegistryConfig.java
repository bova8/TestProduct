package com.example.demo.utils;

import com.example.demo.datamodel.Payment;
import com.example.demo.datamodel.Product;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class DefaultRegistryConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(new ProductService());
    }
}
