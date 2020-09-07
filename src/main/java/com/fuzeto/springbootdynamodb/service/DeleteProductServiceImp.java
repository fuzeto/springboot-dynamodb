package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.model.Product;
import com.fuzeto.springbootdynamodb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductServiceImp implements DeleteProductService {

    private ProductRepository repository;

    public DeleteProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }
}
