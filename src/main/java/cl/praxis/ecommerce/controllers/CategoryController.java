package cl.praxis.ecommerce.controllers;

import cl.praxis.ecommerce.entities.Category;
import cl.praxis.ecommerce.entities.Product;
import cl.praxis.ecommerce.services.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping("/new")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Long id) {
        Category categoryUpdated = categoryService.getById(id);

        categoryUpdated.setCategoryName(category.getCategoryName());
        categoryUpdated.setProductList(category.getProductList());

        return categoryService.update(categoryUpdated);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
