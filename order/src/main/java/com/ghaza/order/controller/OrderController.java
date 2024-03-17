/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ghaza.order.controller;

import com.ghaza.order.entity.Order;
import com.ghaza.order.service.OrderService;
import com.ghaza.order.vo.Responses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author muham
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order>getAll(){
        return orderService.getAll();
        
    }
    
    @PostMapping
    public void insert(@RequestBody Order order){
        orderService.insert(order);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        orderService.delete(id);
    }
    
     @PutMapping(path = "{id}")
    public void update(@PathVariable("id")Long id,
            @RequestParam(required =false) String jumlah,
            @RequestParam(required =false) String tanggal,
            @RequestParam(required =false) String status)
    {
        orderService.update(id, Integer.SIZE, tanggal, status);
    }

    @GetMapping(path ="{/product/id}")
    public Responses getOrderWithProductById(@PathVariable("id")Long id){
    return orderService.getOrderWithProductById(id);
    }
}
