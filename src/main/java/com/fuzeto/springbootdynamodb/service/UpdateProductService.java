package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.controller.input.ProductInput;
import com.fuzeto.springbootdynamodb.model.Product;

public interface UpdateProductService {

    public Product update(Product product, ProductInput input);
}
