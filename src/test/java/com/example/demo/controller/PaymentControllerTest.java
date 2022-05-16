package com.example.demo.controller;

import com.example.demo.datamodel.Payment;
import com.example.demo.datamodel.Product;
import com.example.demo.utils.DefaultRegistryConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import(DefaultRegistryConfig.class)
public class PaymentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testPutProductOk() throws Exception {
        Product product = new Product("1234567890123", "milk");
        Payment payment = new Payment("123456789", "123456789", Arrays.asList(product));

        mockMvc.perform(post("/postPayment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payment))
        ).andExpect(status().isOk());
    }

    @Test
    void testPutProductnNokBadCustomer() throws Exception {
        Product product = new Product("1234567890123", "milk");
        Payment payment = new Payment("123", "123456789", Arrays.asList(product));
        mockMvc.perform(post("/postPayment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payment))
        ).andExpect(status().isBadRequest());
    }
}
