package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.controller.input.ProductInput;
import com.fuzeto.springbootdynamodb.model.Product;
import com.fuzeto.springbootdynamodb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductServiceImp implements UpdateProductService {

    private ProductRepository repository;

    public UpdateProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    public Product update(Product product, ProductInput input) {
        Product entity = product.update(input.getName(), input.getCost());
        return repository.save(entity);
    }
}
