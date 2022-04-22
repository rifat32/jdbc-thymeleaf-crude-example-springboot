package com.example.jdbcexample.net.codejava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private int id;
    private String item;
    private int quantit;
    private float amount;

}
