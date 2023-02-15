package com.pellin.api.service;

import com.pellin.api.model.Productos;
import com.pellin.api.repository.ProductRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public List<Productos>listProducts(){
        return repository.findAll();
    }
    
    public void saveProduct(Productos product){
        repository.save(product);
    }
    
    public Productos getProductById(Integer id){
        return repository.findById(id).get();
    }
    
    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}
