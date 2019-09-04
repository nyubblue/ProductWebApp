/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author buynl
 */
@Entity
@Table(name = "shipping")
public class ShippingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 150)
    private String phone;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(name = "id_card", length = 150) 
    private String idCard;

    @OneToMany(mappedBy = "shipping_entity",
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    private List<OrderEntity> orderEntitys;
 
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public List<OrderEntity> getOrderEntitys() {
        return orderEntitys;
    }

    public void setOrderEntitys(List<OrderEntity> orderEntitys) {
        this.orderEntitys = orderEntitys;
    }

}
