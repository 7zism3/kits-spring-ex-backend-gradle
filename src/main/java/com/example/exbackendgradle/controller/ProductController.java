package com.example.exbackendgradle.controller;

import com.example.exbackendgradle.entity.Product;
import com.example.exbackendgradle.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
//@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {

    @GetMapping("/test")
    public List<Product> getProducts1() {
        List<Product> products = null;
        products.add(new Product(Long.valueOf(1), "name 1", "https://product.hstatic.net/1000283534/product/maudo_1_905989224c894544bb75eb82e3446060.png", 123));
        products.add(new Product(Long.valueOf(2), "name 2", "https://cdn.tgdd.vn/Products/Images/42/190325/TimerThumb/iphone-xr-(4).jpg", 150));
        products.add(new Product(Long.valueOf(3), "name 3", "https://m.media-amazon.com/images/I/81F-QC1N5WL._AC_SY550_.jpg", 110));
        products.add(new Product(Long.valueOf(4), "name 4", "https://product.hstatic.net/1000283534/product/maudo_1_905989224c894544bb75eb82e3446060.png", 123));
        products.add(new Product(Long.valueOf(5), "name 5", "https://cdn.tgdd.vn/Products/Images/42/190325/TimerThumb/iphone-xr-(4).jpg", 150));
        products.add(new Product(Long.valueOf(6), "name 6", "https://m.media-amazon.com/images/I/81F-QC1N5WL._AC_SY550_.jpg", 110));
        return products;
    }

    @Autowired
    ProductRepository productRepo;

    @GetMapping("")
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable("id") Long id) {
        // Áp dụng jpa
        return productRepo.findById(id).orElse(null);

//        List<Product> products = productRepo.findAll();
//        for (Product product : products) {
//            if (product.getId() == id)
//                return product;
//        }
//        return null;
    }

    @PostMapping(path = "") // Map ONLY POST Requests
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Product addNewProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Product> updateTutorial(@PathVariable("id") Long id, @RequestBody Product product) {
        return productRepo.findById(id).map(product1 -> {
            product.setId(product1.getId());
            return new ResponseEntity<>(productRepo.save(product), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PutMapping(path = "/{id}")
//    @ResponseBody
//    public String updateTutorial(@PathVariable("id") Long id, @RequestBody Product product) {
//        return  productRepo.findById(id)
//                .map(entity -> {
//                    productRepo.save(product);
//                    return "sucess";
//                })
//                .orElseGet(() -> {
//                    return "not_found";
//                });
//    }


    @DeleteMapping("/{id}")
    public void deleteTutorial(@PathVariable("id") Long id) {
        productRepo.deleteById(id);
    }


}