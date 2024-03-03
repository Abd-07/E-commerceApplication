package com.products.eCommApplication.demo;

import com.products.eCommApplication.demo.entity.Product;
//import com.products.eCommApplication.demo.service.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Slf4j
public class ProductController {
    @Autowired
    com.products.eCommApplication.demo.entity.ProductService ProductService;

    @GetMapping(path="/")
    @ResponseBody
    public String getHome() {
//        log.info("[CUSTOM LOG] calling controller.getHome");
        return "[CUSTOM LOG] calling controller.getHome";
    }

    @GetMapping(path="/getProducts")
    @ResponseBody
    public List getProducts() {
//        log.info("[CUSTOM LOG] calling controller.getProducts");
        System.out.println("[CUSTOM LOG] calling controller.getProducts");
        return ProductService.getProducts();
    }

    @GetMapping(path="/getProducts/{productId}")
    public Product getProductsWithId(@PathVariable int productId) {
        log.info("getProductsId called");
        return ProductService.getProductsWithId(productId);
    }

    @GetMapping(path="/getProducts/productName")
    public Product getProductsWithName(@RequestParam(value="name") String productName) {
        return ProductService.getProductsWithName(productName);
    }

    @PostMapping(path="addProduct")
    public Product addProduct(@RequestBody Product addedProduct) {
        return ProductService.addProduct(addedProduct);
    }

    @PutMapping(path="updateProduct")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        return ProductService.updateProduct(updatedProduct);
    }

    @DeleteMapping(path="deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        return ProductService.deleteProduct(productId);
    }

}