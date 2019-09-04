/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.service;

import com.nubyl.productwebapp.entities.ProductEntity;
import com.nubyl.productwebapp.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buynl
 */
@Service
public class ProductService {
   @Autowired
    private ProductRepository productRepository;
    
     public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }
     public ProductEntity findById(Integer id){
        return  productRepository.findOne(id);
     }

}
