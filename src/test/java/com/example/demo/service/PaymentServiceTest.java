package com.example.demo.service;

import com.example.demo.datamodel.Payment;
import com.example.demo.datamodel.Product;
import com.example.demo.exception.ValidationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
public class PaymentServiceTest {

    PaymentService paymentService;

    @MockBean
    ProductService productService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        paymentService = new PaymentService(productService);
    }

    @Test
    @DisplayName("Validation is ok")
    public void testValidateOkPayment() {
        Product product = new Product("1234567890123", "milk");
        Payment payment = new Payment("123456789", "123456789", Arrays.asList(product));

        paymentService.validate(payment);
    }

    @Test
    @DisplayName("Validation is nok: seller length is too short")
    public void testValidateSellerWrongPayment() {

        Product product = new Product("1234567890123", "milk");
        Payment payment = new Payment("wrong", "123456789", Arrays.asList(product));

        thrown.expect(ValidationException.class);
        thrown.expectMessage("Invalid Seller length. It must be 9 symbols!");

        paymentService.validate(payment);
    }
}
