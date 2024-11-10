package cl.praxis.ecommerce.controllers;

import cl.praxis.ecommerce.entities.Product;
import cl.praxis.ecommerce.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping("/new")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Product productUpdated = productService.getById(id);

        productUpdated.setProductName(product.getProductName());
        productUpdated.setDescription(product.getDescription());
        productUpdated.setPrice(product.getPrice());
        productUpdated.setStock(product.getStock());
        productUpdated.setCategory(product.getCategory());

        return productService.update(productUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
