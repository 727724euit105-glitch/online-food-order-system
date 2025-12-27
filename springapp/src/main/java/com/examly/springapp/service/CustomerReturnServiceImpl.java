package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;
import com.examly.springapp.service.CustomerReturnService;

import io.micrometer.common.lang.NonNull;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {

    @Autowired
    private CustomerReturnRepo customerReturnRepo;

    @Override
    public CustomerReturn addCustomerReturn(CustomerReturn customerReturn) {
        return customerReturnRepo.save(customerReturn);
    }

    @Override
    public List<CustomerReturn> getAllCustomerReturns() {
        return customerReturnRepo.findAll();
    }

   
    @Override
    public CustomerReturn getCustomerReturnById( Long id) {
       return customerReturnRepo.findById(id).orElse(null);
    }

    
}

   











