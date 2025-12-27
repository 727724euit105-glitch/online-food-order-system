package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.service.PurchaseOrderItemService;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {

    @Autowired
    private PurchaseOrderItemService purchaseOrderItemService;

    @PostMapping
    public ResponseEntity<PurchaseOrderItem> addPurchaseOrderItem(@RequestBody PurchaseOrderItem item) {
        PurchaseOrderItem created = purchaseOrderItemService.addPurchaseOrderItem(item);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getItemsByOrderId(@PathVariable Long orderId) {
        List<PurchaseOrderItem> items = purchaseOrderItemService.getItemsByOrderId(orderId);
        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(items);
    }
}









