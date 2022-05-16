package com.example.demo.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NonNull
    private String code;
    @NonNull
    private String name;
}
