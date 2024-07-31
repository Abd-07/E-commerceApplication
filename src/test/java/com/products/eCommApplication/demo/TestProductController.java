package com.products.eCommApplication.demo;

import com.products.eCommApplication.demo.entity.Product;
import com.products.eCommApplication.demo.entity.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest(classes={ProductController.class})
public class TestProductController {
    @MockBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    public void testGetProducts() {
        // given
        List<Product> productList = new ArrayList<>();
        when(productService.getProducts()).thenReturn(productList);

        // when
        List<Product> result = productController.getProducts();

        // then
        assertEquals(productList, result);
    }

    @Test
    public void testGetProductsWithId() {
        // given
        long productId = 123;
        Product expectedProduct = new Product(productId, "Test Product", 10.0);
        when(productService.getProductsWithId(anyInt())).thenReturn(expectedProduct);

        Product firstProduct = productService.getProductsWithId(1);
        Product secondProduct = productService.getProductsWithId(2);
        Product thirdProduct = productService.getProductsWithId(3);

        // when
        Product serviceResult = productService.getProductsWithId(123);
        Product result = productController.getProductsWithId(123);

//        Product result = productController.getProductsWithId((int) productId);

        // then
        assertEquals(expectedProduct, result);
    }

    @Test
    public void testAddProduct() {
        Product productToAdd = new Product(123L, "New Product", 15.0);

        when(productService.addProduct(Mockito.any(Product.class))).thenReturn(productToAdd);

        Product result = productController.addProduct(productToAdd);

        assertEquals(productToAdd, result);
    }
}
