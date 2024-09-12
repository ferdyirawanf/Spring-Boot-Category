package com.example.eStoreCategory.utils.specification;

import com.example.eStoreCategory.model.Category;
import org.springframework.data.jpa.domain.Specification;

import java.util.function.Predicate;

public class CategorySpecification {
    public static Specification<Category> withName(String categoryName) {
        return ((root, query, criteriaBuilder) ->
                categoryName == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + categoryName.toLowerCase() + "%"));
    }

    // Predicate to determine if a specification should be applied
    public static <T> Specification<T> specificationFromPredicate(Specification<T> spec, Predicate<?> predicate) {
        return (root, query, criteriaBuilder) -> predicate.test(null) ? spec.toPredicate(root, query, criteriaBuilder): null;
    }
}
