package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    
    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    
    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null);
    }

    
    @Override
    public Product updateProduct(long id, Product product) {
        if (productRepo.existsById(id)) {
            product.setProductId(id);
            return productRepo.save(product);
        }
        return null;
    }
}















