package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Product;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();


    Product updateProduct(long id, Product product);

    Product getProductById(long id);

}











