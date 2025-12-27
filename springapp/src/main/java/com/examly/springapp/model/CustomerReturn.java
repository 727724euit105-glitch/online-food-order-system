package com.examly.springapp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerReturnId;

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private LocalDate returnDate;
    private String reason;

    public CustomerReturn() {
    }

    public CustomerReturn(Long customerReturnId, Long orderId, Long productId, Integer quantity, LocalDate returnDate, String reason) {
        this.customerReturnId = customerReturnId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.returnDate = returnDate;
        this.reason = reason;
    }

    public Long getCustomerReturnId() {
        return customerReturnId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setCustomerReturnId(Long customerReturnId) {
        this.customerReturnId=customerReturnId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

