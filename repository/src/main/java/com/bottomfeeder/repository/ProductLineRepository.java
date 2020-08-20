package com.bottomfeeder.repository;

import java.util.List;
import java.util.Optional;

import com.bottomfeeder.model.Product;
import com.bottomfeeder.model.ProductLine;

public interface ProductLineRepository {
    int count();

    int save(ProductLine productLine);

    int update(ProductLine productLine);

    int deleteById(Long id);

    List<ProductLine> findAll();

    ProductLine findByProductLine(String productLine);

    // jdbcTemplate.queryForObject, populates a single object
    Optional<Product> findById(String id);

}
