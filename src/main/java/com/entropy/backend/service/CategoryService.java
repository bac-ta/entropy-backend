package com.entropy.backend.service;

import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.CategoryDTO;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.entity.Post;
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

import java.util.List;
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
        return categoryRepository.findAllByStatusType(StatusType.ON.getName()).stream().
                map(category -> new CategoryGetResp(category.getId(), category.getCategoryType())).
                collect(Collectors.toList());
    }

    public List<CategoryDTO> findCategories(int sort, int limit, int start) {
        logger.debug("Find categories");
        logger.info("start: " + start + ", limit: " + limit);

        Pageable pageable = PageRequest.of(start, limit, Sort.by(SortType.findByValue(sort).getName(), "id"));
        return categoryRepository.findAll(pageable).stream()
                .map(category -> new CategoryDTO(category.getId(), category.getCategoryType(), category.getUpdated().toString(), category.getStatusType().getName()))
                .collect(Collectors.toList());
    }

}
