package com.fuzeto.springbootdynamodb.service;

import com.fuzeto.springbootdynamodb.model.Product;

public interface DeleteProductService {

    public void delete(Product product);
}
