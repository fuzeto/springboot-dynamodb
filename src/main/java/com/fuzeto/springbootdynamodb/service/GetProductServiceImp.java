package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.model.Product;
import com.fuzeto.springbootdynamodb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetProductServiceImp implements GetProductService {

    private final ProductRepository productRepository;

    public GetProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findOneBy(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
}
