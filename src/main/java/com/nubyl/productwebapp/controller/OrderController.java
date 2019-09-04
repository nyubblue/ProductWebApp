/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.controller;

import com.nubyl.productwebapp.entities.OrderDetail;
import com.nubyl.productwebapp.entities.OrderEntity;
import com.nubyl.productwebapp.entities.ProductEntity;
import com.nubyl.productwebapp.service.OrdersService;
import com.nubyl.productwebapp.service.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author buynl
 */
@Controller
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService ps;

    @RequestMapping(value = "/order_product", method = RequestMethod.GET)
    public String orderProduct(Model m,
            @RequestParam("productId") Integer productId, HttpSession session) {
        ProductEntity pe = ps.findById(productId);
        if (pe != null) {
            double totalPrice = 0;
            OrderEntity order = (OrderEntity) session.getAttribute("order");
            if (order != null) {
                List<OrderDetail> orderDetails = order.getOrderDetails();
                if (orderDetails != null && orderDetails.size() > 0) {
                    int flagNotEqual = 1;
                    for (int i = 0; i < orderDetails.size(); i++) {

                        if (orderDetails.get(i).getProduct_entity().getId() == productId) {
                            int temp = orderDetails.get(i).getQuantity();
                            orderDetails.get(i).setQuantity(temp + 1);
                             ordersService.saveOrderDetail(orderDetails.get(i));
                            flagNotEqual = 0;
                        }
                        totalPrice += (orderDetails.get(i).getQuantity()) * (orderDetails.get(i).getPrice());
                        

                    }
                    if (flagNotEqual == 1) {
                        OrderDetail addOrderDetail = new OrderDetail();
                        addOrderDetail.setName(pe.getName());
                        addOrderDetail.setPrice(pe.getPrice());
                        addOrderDetail.setQuantity(1);
                        addOrderDetail.setOrder_entity(order);
                        addOrderDetail.setProduct_entity(pe);
                        addOrderDetail = ordersService.saveOrderDetail(addOrderDetail);
                        orderDetails.add(addOrderDetail);
                        totalPrice += pe.getPrice();
                    }
                    order.setTotalPrice(totalPrice);
                    order.setOrderDetails(orderDetails);
                }
               order =  ordersService.saveOrder(order);
                session.removeAttribute("order");
                session.setAttribute("order", order);
            } else {
                order = new OrderEntity();
                order.setOrderDate(new Date());
                order.setStatus("Waiting");
                order =  ordersService.saveOrder(order);
                List<OrderDetail> orderDetails = new ArrayList<>();
                OrderDetail detail = new OrderDetail();
               detail.setName(pe.getName());
               detail.setOrder_entity(order);
                detail.setPrice(pe.getPrice());
              detail.setProduct_entity(pe);
                detail.setQuantity(1);
                detail.setOrder_entity(order);
               detail = ordersService.saveOrderDetail(detail);
                orderDetails.add(detail);
                order.setOrderDetails(orderDetails);
                order.setTotalPrice(pe.getPrice());
                order =  ordersService.saveOrder(order);
                session.setAttribute("order", order);
                m.addAttribute("order", order);
            }
        }
        return "redirect:/view_order";
    }

    @RequestMapping(value = "/view_order")
    public String viewOrder(Model m) {

        return "a_order";
    }

    @RequestMapping(value = "/update_order")
    public String updateOrder(Model m, HttpSession session,
            @RequestParam("quantity") Integer[] numq
    ) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order != null) {
            List<OrderDetail> orderDetails = order.getOrderDetails();
            float totalPrice = 0;
            if (orderDetails != null && orderDetails.size() > 0) {
                for (int i = 0; i < numq.length; i++) {
                    orderDetails.get(i).setQuantity(numq[i]);
                    totalPrice += numq[i] * (orderDetails.get(i).getPrice());
                    ordersService.saveOrderDetail(orderDetails.get(i));
                }
                order.setOrderDetails(orderDetails);
                session.removeAttribute("order");
                order.setTotalPrice(totalPrice);
                order = ordersService.saveOrder(order);
                session.setAttribute("order", order);
            }
        }
        return "redirect:/view_order";
    }

    @RequestMapping(value = "/delete_dt/{pid}")
    public String deleteDetail(Model m, @PathVariable("pid") int pid, HttpSession session) {
        OrderEntity order = (OrderEntity) session.getAttribute("order");
        if (order != null) {
            List<OrderDetail> orderDetails = order.getOrderDetails();
            if (orderDetails != null && orderDetails.size() > 0) {
                Iterator<OrderDetail> it = orderDetails.iterator();
                double decreamentTotalPrice =0;
                while (it.hasNext()) {
                        OrderDetail od = it.next();
                    if (pid == od.getId()) {
                        ordersService.saveOrderDetail(od);
                        it.remove();
                    }
                }
                order.setTotalPrice(order.getTotalPrice()-decreamentTotalPrice);
                session.removeAttribute("order");
                session.setAttribute("order", order);
                m.addAttribute("order", order);
            }
        }
        return "redirect:/view_order";
    }
    @RequestMapping(value="/submit_order")
    public String doneOrder(Model m, HttpSession session){
        OrderEntity order = (OrderEntity)session.getAttribute("order");
        if(order!=null){
            order.setStatus("Ordered");
            ordersService.saveOrder(order);
            session.invalidate();
        }
        
        return "redirect:/home";
    }
}