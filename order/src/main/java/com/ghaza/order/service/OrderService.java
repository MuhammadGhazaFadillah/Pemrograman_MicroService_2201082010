/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ghaza.order.service;

import com.ghaza.order.entity.Order;
import com.ghaza.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author muham
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    
    public Order getOrderById(long id){
        return orderRepository.getReferenceById(id);
    }
    
    public void insert(Order order){
        orderRepository.save(order);
    }
    
    @Transactional
    public void update(Long id, Long produkId, Integer jumlah, String tanggal, String status, double total){
        Order order = orderRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("Produk tidak ada")
                );
         if (jumlah != null) {
            order.setJumlah(jumlah);
        }

        if(tanggal != null && tanggal.length()>0
                && !Objects.equals(order.getTanggal(), tanggal)){
            order.setTanggal(tanggal);
        }
        if(status != null && status.length()>0
                && !Objects.equals(order.getStatus(), status)){
            order.setStatus(status);
        }       
   }
   public void delete(Long id){
        orderRepository.deleteById(id);
    }

    public void update(Long id, String jumlah, String tanggal, String satuan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

