package com.bottomfeeder.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.bottomfeeder.model.Product;

public interface ProductRepository {
    int count();

    int save(Product product);

    int update(Product product);

    int deleteById(Long id);

    List<Product> findAll();

    List<Product> findByProductLine(String productLine);

    // jdbcTemplate.queryForObject, populates a single object
    Optional<Product> findById(String id);

    List<Product> findByNameAndPrice(String name, BigDecimal price);

    String getNameById(String id);
}
