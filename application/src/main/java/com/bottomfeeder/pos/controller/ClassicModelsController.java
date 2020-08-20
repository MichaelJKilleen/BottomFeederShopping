package com.bottomfeeder.pos.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.bottomfeeder.pos.service.MyService;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classicmodels")
public class ClassicModelsController {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final ProductRepository productRepository;
    private final IClassicModelsSerivce classicModelsSerivce;

    public ClassicModelsController(final ProductRepository productRepository,
            final IClassicModelsSerivce classicModelsSerivce) {
        this.productRepository = productRepository;
        this.classicModelsSerivce = classicModelsSerivce;
    }

    @GetMapping("/products")
    // @Secured("ROLE_USER")
    public List<Product> get(@RequestParam(value = "productLine", defaultValue = "") final String productLine) {
        List<Product> products = (List<Product>) productRepository.findAll();
        if (!productLine.equals("")) {
            products = products.stream().filter(product -> product.getProductLine().equals(productLine))
                    .collect(Collectors.toList());
        }
        products.forEach(product -> System.out.println(product.getProductCode()));

        return products;
    }

    // @GetMapping("/productlines/productLine")
    // public List<ProductLine> getProductLine(@PathVariable("productLine") String
    // productLine) {
    @GetMapping("/productlines")
    // @Secured("ROLE_USER")
    public List<ProductLine> getProductLine(
            @RequestParam(value = "productLine", defaultValue = "") final String productLine) {
        List<ProductLine> productLines = classicModelsSerivce.FindAllProductLines();
        if (!productLine.equals("")) {
            productLines = productLines.stream()
                    .filter(productLine1 -> productLine1.getProductLine().equals(productLine))
                    .collect(Collectors.toList());
        }
        return productLines;
    }

    @PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    // @Secured("ROLE_ADMIN")
    public String patch(@PathVariable("id") final int id, @RequestBody final String employee) {
        LOGGER.debug("id: " + id + ", employee: " + employee);
        return "Done";
    }

}