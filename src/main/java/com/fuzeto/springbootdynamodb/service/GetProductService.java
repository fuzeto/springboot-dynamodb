package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.model.Product;

import java.util.List;
import java.util.Optional;

public interface GetProductService {

    Optional<Product> findOneBy(String id);
    List<Product> findAll();
}
