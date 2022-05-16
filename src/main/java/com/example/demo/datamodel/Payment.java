package com.example.demo.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @NonNull
    private String seller;
    @NonNull
    private String customer;

    @NonNull
    private List<Product> products;
}
