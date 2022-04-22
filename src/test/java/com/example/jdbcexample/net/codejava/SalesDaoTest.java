package com.example.jdbcexample.net.codejava;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SalesDaoTest {
private SalesDao dao;
    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dao = new SalesDao(new JdbcTemplate(dataSource));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list() {
        List<Sale> listSale = dao.list();
        assertFalse(listSale.isEmpty());
    }

    @Test
    void save() {
        Sale sale = new Sale(1,"ddd",1,1);
        dao.save(sale);

    }

    @Test
    void get() {
        int id = 2;
        Sale sale = dao.get(id);
        assertNotNull(sale);
    }

    @Test
    void update() {
        Sale sale = new Sale(1,"fgg",5,6);
        dao.update(sale);
    }
    @Test
    void delete() {
       dao.delete(1);

    }
}