package com.example.eStoreCategory.controller;
import com.example.eStoreCategory.DTO.request.CategoryDTO;
import com.example.eStoreCategory.model.Category;
import com.example.eStoreCategory.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public Category create(HttpEntity<CategoryDTO> categoryRequest) {
        return categoryService.create(categoryRequest.getBody());
    }

    @GetMapping
    public List<?> getAll(
            CategoryDTO.Search params)
    {
        System.out.println(categoryService.index(params));
        return categoryService.index(params);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Integer id) {
        return categoryService.show(id);
    }

    @PutMapping("/{id}")
    public Category update(HttpEntity<CategoryDTO> categoryRequest) {
        return categoryService.update(categoryRequest.getBody());
    }

    @DeleteMapping("/{id}")
    public String delete(HttpEntity<Integer> categoryRequest) {
        categoryService.delete(categoryRequest.getBody());
        return "Successful delete category id : " + categoryRequest.getBody();
    }
}
