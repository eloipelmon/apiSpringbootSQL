package com.pellin.api.controller;

import com.pellin.api.model.Productos;
import com.pellin.api.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Controller
public class ProductController {
    @Autowired
    private final ProductService productService;
    
    @GetMapping("/products")
    public List<Productos> listProducts() {
        return productService.listProducts();
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Productos> getProduct(@PathVariable Integer id){
        try{
            Productos product =productService.getProductById(id);
            return ResponseEntity.ok(product);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/products")
    public void newProduct (@RequestBody Productos product){
        productService.saveProduct(product);
    }
    
    @PutMapping("/products/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Productos product,@PathVariable Integer id){
        try{
            Productos ExistingProduct =productService.getProductById(id);
            ExistingProduct.setNombre(product.getNombre());
            ExistingProduct.setPrecio(product.getPrecio());
            
            productService.saveProduct(ExistingProduct);
            return new ResponseEntity<Productos>(product,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Productos>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}