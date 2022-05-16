package com.example.demo.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.NonNull;

@Data
@ToString
@AllArgsConstructor
public class Product {

    @NonNull
    private String code;

    @NonNull
    private String name;
}
