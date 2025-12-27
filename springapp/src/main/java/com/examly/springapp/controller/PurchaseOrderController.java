package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    
    @PostMapping
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(
            @RequestBody(required = false) PurchaseOrder purchaseOrder) {

        if (purchaseOrder == null) {
            return ResponseEntity.badRequest().build(); 
        }

        PurchaseOrder created = purchaseOrderService.addPurchaseOrder(purchaseOrder);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        List<PurchaseOrder> list = purchaseOrderService.getAllPurchaseOrders();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(list); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrder po = purchaseOrderService.getPurchaseOrderById(id);
        return ResponseEntity.ok(po); 
    }
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable Long id,@RequestBody PurchaseOrder purchaseOrder ){
        PurchaseOrder order=purchaseOrderService.updatePurchaseOrder(id,purchaseOrder);
        return ResponseEntity.ok(order);
    }
}



















