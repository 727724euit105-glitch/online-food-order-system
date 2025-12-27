package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestBody(required = false) Product product) {

        if (product == null) {
            return ResponseEntity.badRequest().build(); 
        }

        Product saved = productService.addProduct(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED); 
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        if (products == null || products.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }

        return ResponseEntity.ok(products); 
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {

        Product product = productService.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(product); 
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable long id,
            @RequestBody Product product) {

        Product updated = productService.updateProduct(id, product);

        if (updated == null) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(updated); 
    }
    @DeleteMapping
    public ResponseEntity<Product>delPro(){
        return null;
    }
    
}
















