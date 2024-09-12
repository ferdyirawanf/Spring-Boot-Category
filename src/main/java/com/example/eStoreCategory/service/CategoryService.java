package com.example.eStoreCategory.service;
import com.example.eStoreCategory.DTO.request.CategoryDTO;
import com.example.eStoreCategory.model.Category;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoryService {
    // Create
    Category create(CategoryDTO categoryRequest);
    // Get All
    List<Category> index(CategoryDTO.Search params);
    List<Category> findByNameEquals(String keyword); // TODO
    List<Category> findByNameContaining(String keyword); // TODO
    // Get By Id
    Category show(Integer id);
    // Update
    Category update(CategoryDTO updateRequest);
    //Delete
    void delete(Integer id);
}