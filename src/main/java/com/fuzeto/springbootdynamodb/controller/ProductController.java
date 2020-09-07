package com.fuzeto.springbootdynamodb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuzeto.springbootdynamodb.controller.input.ProductInput;
import com.fuzeto.springbootdynamodb.model.Product;
import com.fuzeto.springbootdynamodb.service.CreateProductService;
import com.fuzeto.springbootdynamodb.service.DeleteProductService;
import com.fuzeto.springbootdynamodb.service.GetProductService;
import com.fuzeto.springbootdynamodb.service.UpdateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final GetProductService getProductService;
    private final CreateProductService createProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    public ProductController(
            GetProductService getProductService,
            CreateProductService createProductService,
            UpdateProductService updateProductService,
            DeleteProductService deleteProductService
    ) {
        this.getProductService = getProductService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(getProductService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody String product) throws Exception {
        ProductInput productInput = new ObjectMapper().readValue(product, ProductInput.class);
        return ResponseEntity.ok(createProductService.create(productInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") String id, @RequestBody String product) throws Exception {
        ProductInput newProduct = new ObjectMapper().readValue(product, ProductInput.class);

        Optional<Product> existentProduct = getProductService.findOneBy(id);

        if (existentProduct.isPresent()) {
            return ResponseEntity.ok(updateProductService.update(existentProduct.get(), newProduct));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        Optional<Product> product = getProductService.findOneBy(id);

        if (product.isPresent()) {
            deleteProductService.delete(product.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
