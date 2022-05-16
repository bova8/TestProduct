package com.example.demo.controller;

import com.example.demo.datamodel.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    static final Logger logger = Logger.getLogger(PaymentController.class.getName());

    private PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/postPayment")
    public ResponseEntity postPayment(@RequestBody Payment payment) {
        logger.info("Payment: " + payment);
        paymentService.validate(payment);
        return ResponseEntity.ok().build();
    }
}
