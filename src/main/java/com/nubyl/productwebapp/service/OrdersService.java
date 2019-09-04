/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.service;

import com.nubyl.productwebapp.entities.OrderDetail;
import com.nubyl.productwebapp.entities.OrderEntity;
import com.nubyl.productwebapp.repositories.OrderDetailRepository;
import com.nubyl.productwebapp.repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author buynl
 */
@Service
public class OrdersService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderDetailRepository detailRepository;
    
    public OrderEntity findOrderById(int id){
        return orderRepository.findOne(id);
    }
    public List<OrderDetail> getListOfOrderDetail(){
        return (List<OrderDetail>)detailRepository.findAll();
    }
     public OrderEntity saveOrder( OrderEntity entity){
         return orderRepository.save(entity);
     }
     public OrderDetail saveOrderDetail(OrderDetail orderDetail){
            return detailRepository.save(orderDetail);
     }
}
