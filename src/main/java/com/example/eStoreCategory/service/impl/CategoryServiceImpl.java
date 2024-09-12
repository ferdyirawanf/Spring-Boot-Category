package com.example.eStoreCategory.service.impl;
import com.example.eStoreCategory.DTO.request.CategoryDTO;
import com.example.eStoreCategory.model.Category;
import com.example.eStoreCategory.repository.CategoryRepository;
import com.example.eStoreCategory.service.CategoryService;
import com.example.eStoreCategory.utils.specification.CategorySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryDTO categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> index(CategoryDTO.Search params) {
        Specification<Category> specification = Specification.where(null);

        specification = specification.and(CategorySpecification.specificationFromPredicate(
                CategorySpecification.withName(params.getName()),
                p -> params.getName() != null && !params.getName().isEmpty()
        ));

        return categoryRepository.findAll(specification); // solved cara 2
    }

    @Override
    public List<Category> findByNameEquals(String name) {
        return categoryRepository.findByNameEqualsIgnoreCase(name);
    }

    @Override
    public List<Category> findByNameContaining(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Category show(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category update(CategoryDTO updateRequest) {
        Category category = show(updateRequest.getId());
        assert category != null;

        if (updateRequest.getName() != null && !updateRequest.getName().trim().isEmpty()) {
            category.setName(updateRequest.getName());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be empty");
        }

        categoryRepository.save(category);
        return category;
    }

    @Override
    public void delete(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            System.out.println("halooo");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}
