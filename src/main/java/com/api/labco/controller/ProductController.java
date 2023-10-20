package com.api.labco.controller;

import com.api.labco.entity.Product;
import com.api.labco.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Object> addNewProduct(@RequestBody Product product){
        System.out.println(product.getApplication());
        return productService.addNewProductWithApplicationId(product);
    }

    @GetMapping("/product")
    public ResponseEntity<Object> getAllProduct(@RequestParam("page") int page,@RequestParam("size") int size){
        return productService.getAllProduct(page,size);
    }
     @GetMapping("search/product")
    public ResponseEntity<Object> searchProduct(@RequestParam("searchItem") String searchItem){
        return productService.searchAllProduct(searchItem);
    }

    @GetMapping("/application/{id}/product")
    public ResponseEntity<Object> getAllProductByApplication(@PathVariable("id") int id,@RequestParam("page") int page,@RequestParam("size") int size){
        return productService.getAllProductByApplication(id,page,size);
    };

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

}
