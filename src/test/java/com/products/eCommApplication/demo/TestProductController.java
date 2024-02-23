package com.products.eCommApplication.demo;

import com.products.eCommApplication.demo.controller.ProductController;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes={ProductController.class})
public class TestProductController {
    @MockBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    public void testGetProducts() {
        List<Product> productList = new ArrayList<>();

        when(productService.getProducts()).thenReturn(productList);

        List<Product> result = productController.getProducts();

        assertEquals(productList, result);
    }

    @Test
    public void testGetProductsWithId() {
        long productId = 123;
        Product expectedProduct = new Product(productId, "Test Product", 10.0);

        when(productService.getProductsWithId(anyLong())).thenReturn(expectedProduct);

        Product result = productController.getProductsWithId((int) productId);

        assertEquals(expectedProduct, result);
    }

    @Test
    public void testAddProduct() {
        Product productToAdd = new Product(123, "New Product", 15.0);

        when(productService.addProduct(Mockito.any(Product.class))).thenReturn(productToAdd);

        Product result = productController.addProduct(productToAdd);

        assertEquals(productToAdd, result);
    }
}
