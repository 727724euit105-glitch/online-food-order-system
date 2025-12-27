package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {

    @Autowired
    private CustomerReturnService customerReturnService;

    @PostMapping
    public ResponseEntity<CustomerReturn> addCustomerReturn(@RequestBody CustomerReturn customerReturn) {
        CustomerReturn created = customerReturnService.addCustomerReturn(customerReturn);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomerReturns() {
        List<CustomerReturn> list = customerReturnService.getAllCustomerReturns();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getCustomerReturnById(@PathVariable Long id) {
        CustomerReturn customerReturn=customerReturnService.getCustomerReturnById(id);
        if(customerReturn==null){
            customerReturn=new CustomerReturn();
            customerReturn.setCustomerReturnId(id);
        }
        return new ResponseEntity<>(customerReturn,HttpStatus.OK);
    }
}


















