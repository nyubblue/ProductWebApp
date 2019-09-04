/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author buynl
 */
@Entity
@Table(name = "order_detail")
public class OrderDetail  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    
    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity order_entity;
    
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product_entity;
    
    // setter , getter ,

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderEntity getOrder_entity() {
        return order_entity;
    }

    public void setOrder_entity(OrderEntity order_entity) {
        this.order_entity = order_entity;
    }

    public ProductEntity getProduct_entity() {
        return product_entity;
    }

    public void setProduct_entity(ProductEntity product_entity) {
        this.product_entity = product_entity;
    }

}
