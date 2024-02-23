package com.products.eCommApplication.demo.entity;
import com.products.eCommApplication.demo.entity.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("MAIN CLASS");
    // create the dummy existing data first, stored in a hashmap
    public ProductService() {
        ProductMap.put(1, product1);
        ProductMap.put(2, product2);
        ProductMap.put(3, product3);
    }

    HashMap<Integer, Product> ProductMap = new HashMap<Integer,Product>();
    Product product1 = new Product(1L,"Laptop",1200);
    Product product2 = new Product(2L,"Phone",300);
    Product product3 = new Product(3L,"Calculator", 15);

    public List getProducts() {
        logger.info("[CUSTOM LOG] product map values" + ProductMap.values());
        List<Product> list = new ArrayList<Product>(ProductMap.values());
        logger.info("[CUSTOM LOG] list values" + list);
        return list;
    }

    public Product getProductsWithId(int productId) {
        Product productMapResult = ProductMap.get(productId);
        return ProductMap.get(productId);
    }

    public Product getProductsWithName(String ProductName) {
        for(int i=0;i<ProductMap.size();i++){
            if (Objects.equals(ProductName, ProductMap.get(i + 1).getName())) {
                return ProductMap.get(i+1);
            }
        }
        return new Product(0L,"NONE",0);
    }

    public Product addProduct(Product addedProduct) {
        int maxId = ProductMap.size()+1;
        addedProduct.setId((long)maxId);
        ProductMap.put(maxId,addedProduct);
        return ProductMap.get(maxId);
    }

    public Product updateProduct(Product updatedProduct) {
        ProductMap.put(Math.toIntExact(updatedProduct.getId()), updatedProduct);
//        return ProductMap.get(updatedProduct.getId());
        return updatedProduct;
    }

    public String deleteProduct(int productId) {
        ProductMap.remove(productId);
        return "Product deleted";
    }
}

