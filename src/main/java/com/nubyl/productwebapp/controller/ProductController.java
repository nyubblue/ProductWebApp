/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.controller;

import com.nubyl.productwebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author buynl
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    
  @RequestMapping(value={"/","/home"},method = RequestMethod.GET )
    public String home(Model model){
        model.addAttribute("products", productService.getProducts());
        return "index";
    }
     @RequestMapping("/continue")
    public String continueOrder(Model m){
        m.addAttribute("products", productService.getProducts());
        return "index";
    }
}
