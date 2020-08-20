package com.bottomfeeder.serviceimpl;

import org.springframework.stereotype.Service;

import java.util.List;

import com.bottomfeeder.model.Product;
import com.bottomfeeder.model.ProductLine;
import com.bottomfeeder.repository.ProductLineRepository;
import com.bottomfeeder.repository.ProductRepository;
import com.bottomfeeder.serviceapi.IClassicModelsSerivce;

@Service
public class ClassicModelsService implements IClassicModelsSerivce {

    private ProductLineRepository productLineRepository;
    private ProductRepository productRepository;

    public ClassicModelsService(ProductLineRepository productLineRepository, ProductRepository productRepository) {
        this.productLineRepository = productLineRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductLine> FindAllProductLines() {
        List<ProductLine> productLineList = productLineRepository.findAll();
        productLineList.forEach(productLine -> {
            List<Product> products = productRepository.findByProductLine(productLine.getProductLine());
            productLine.setProductList(products);
        });
        return productLineList;
    }

    @Override
    public List<ProductLine> FindByCode(int code) {
        return null;
    }

    @Override
    public void Bingo() {
        System.out.println("Does Nothing");
    }
}