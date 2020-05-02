package com.entropy.backend.service;

import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.CategoryDTO;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.model.rest.response.category.CategoryGetResp;
import com.entropy.backend.repository.CategoryRepository;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<CategoryGetResp> findCategoryListEnable() {
        logger.debug("Find categories enable");
        return categoryRepository.findAllByStatusType(StatusType.ON).stream().
                map(category -> new CategoryGetResp(category.getId(), category.getCategoryType())).
                collect(Collectors.toList());
    }

    public List<CategoryDTO> findCategories(int sort, int limit, int start) {
        logger.debug("Find categories");
        logger.info("start: " + start + ", limit: " + limit);
        Pageable pageable = null;

        if (SortType.findByValue(sort) == SortType.ASC)
            pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, "id"));
        else if (SortType.findByValue(sort) == SortType.DESC)
            pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.DESC, "id"));

        List<Category> categories = categoryRepository.findAll(pageable).getContent();
        if (categories.isEmpty())
            return new ArrayList<>();

        return categories.stream()
                .map(category -> new CategoryDTO(category.getId(), category.getCategoryType(), category.getUpdated().toString(), category.getStatusType().getName()))
                .collect(Collectors.toList());
    }

    public void changeStatusType(int id, int status) {
        categoryRepository.changeStatusType(id, StatusType.findByValue(status));
    }

    public Category findCategory(int id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent())
            return optionalCategory.get();
        return null;
    }
}
