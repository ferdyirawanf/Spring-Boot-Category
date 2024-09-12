package com.example.eStoreCategory.repository;
import com.example.eStoreCategory.DTO.request.CategoryDTO;
import com.example.eStoreCategory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    List<Category> findByNameEqualsIgnoreCase(String categoryName);
    List<Category> findByNameContainingIgnoreCase(String categoryName);

}
