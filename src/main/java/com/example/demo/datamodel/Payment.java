package com.example.demo.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.NonNull;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class Payment {
    @NonNull
    private String seller;

    @NonNull
    private String customer;

    @NonNull
    private List<Product> products;
}
