/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ghaza.product.service;

import com.ghaza.product.entity.Product;
import com.ghaza.product.repository.ProductRepository;
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
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }
    
    public void insert(Product product){
        productRepository.save(product);
               
    }
    
    @Transactional
    public void update (Long id, String kode, String nama, String stok, Double harga){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product Tidak Ada"));
        if(kode != null && kode.length()>0
                && !Objects.equals(product.getKode(),kode)){
            product.setKode(kode);
        }
        
        if(nama != null && nama.length()>0
                && !Objects.equals(product.getNama(),nama)){
            product.setNama(nama);
        }
        
        if(stok != null && stok.length()>0
                && !Objects.equals(product.getStok(),stok)){
            product.setStok(stok);
        }
        
        if(harga != null 
                && !Objects.equals(product.getHarga(),harga)){
            product.setHarga(harga);
        }
    }
    
    public void delete(Long Id){
        productRepository.deleteById(Id); 
    }  
}
