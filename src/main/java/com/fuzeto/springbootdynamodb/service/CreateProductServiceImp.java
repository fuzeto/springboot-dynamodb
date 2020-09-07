package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.controller.input.ProductInput;
import com.fuzeto.springbootdynamodb.model.Product;
import com.fuzeto.springbootdynamodb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductServiceImp implements CreateProductService {

    private ProductRepository repository;

    public CreateProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product create(ProductInput product) {

        Product entity = Product.builder()
                .name(product.getName())
                .cost(product.getCost())
                .build();

        return repository.save(entity);
    }
}
