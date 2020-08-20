package com.bottomfeeder.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Optional;

import com.bottomfeeder.model.Product;
import com.bottomfeeder.model.ProductLine;

@Repository
public class JdbcProductLineRepository implements ProductLineRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcProductLineRepository(JdbcTemplate jdbcTemplate, TransactionTemplate transactionTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int save(ProductLine productLine) {
        return 0;
    }

    @Override
    public int update(ProductLine productLine) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<ProductLine> findAll() {

        return jdbcTemplate.query("select * from productlines",
                (rs, rowNum) -> new ProductLine(rs.getString("productLine"), rs.getString("textDescription"),
                        rs.getString("htmlDescription")));
    }

    @Override
    public ProductLine findByProductLine(String productLine) {
        List<ProductLine> productLines = jdbcTemplate.query("select * from productLines where productLine = ?",
                new Object[] { productLine }, (rs, rowNum) -> new ProductLine(rs.getString("productLine"),
                        rs.getString("textDescription"), rs.getString("htmlDescription")));
        if (!productLines.isEmpty()) {
            return productLines.get(0);
        }
        return new ProductLine("", "", "");
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }
}
