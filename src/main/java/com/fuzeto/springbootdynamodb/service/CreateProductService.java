package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.controller.input.ProductInput;
import com.fuzeto.springbootdynamodb.model.Product;

public interface CreateProductService {

    public Product create(ProductInput product);
}
