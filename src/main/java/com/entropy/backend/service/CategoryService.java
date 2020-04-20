package com.entropy.backend.service;

import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.repository.CategoryRepository;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryCreateReq request) throws ResourceNotFoundExceptionHandler {
        logger.debug("Create category");
        logger.info(request.toString());

        Category categoryInput = new Category();
        categoryInput.setCategoryType(request.getCategoryType());
        return categoryRepository.save(categoryInput);
    }

    public List<Category> findCategoryList() {
        return categoryRepository.findAll();
    }

}
