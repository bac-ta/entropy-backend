package com.entropy.backend.service.impl;

import com.entropy.backend.model.enumeration.SortType;
import com.entropy.backend.model.enumeration.StatusType;
import com.entropy.backend.model.dto.CategoryDTO;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.model.rest.response.category.CategoryFetchResp;
import com.entropy.backend.model.rest.response.category.CategoryGetResp;
import com.entropy.backend.repository.CategoryRepository;
import com.entropy.backend.service.CategoryService;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.apache.commons.lang3.StringUtils;
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
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryCreateReq request) throws ResourceNotFoundExceptionHandler {
        logger.debug("Create category");
        logger.info(request.toString());

        Category categoryInput = new Category();
        categoryInput.setCategoryType(request.getCategoryType());
        return categoryRepository.save(categoryInput);
    }

    @Override
    public List<CategoryGetResp> findCategoryListEnable() {
        logger.debug("Find categories enable");
        return categoryRepository.findAllByStatusType(StatusType.ON).stream().
                map(category -> new CategoryGetResp(category.getId(), category.getCategoryType())).
                collect(Collectors.toList());
    }

    @Override
    public CategoryFetchResp findCategories(int sort, int limit, int start, Integer statusType, String searchText) {
        logger.debug("Find categories");
        logger.info("sort: " + sort + ", start: " + start + ", limit: " + limit + ", status type: " + statusType + ", search text: " + searchText);
        Pageable pageable = null;

        if (SortType.findByValue(sort) == SortType.ASC)
            pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, "id"));
        else if (SortType.findByValue(sort) == SortType.DESC)
            pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.DESC, "id"));

        int count;
        List<Category> categories;

        if (StringUtils.isBlank(searchText) && statusType == null) {
            count = categoryRepository.findAll().size();
            if (count == 0)
                return new CategoryFetchResp(0, new ArrayList<>());
            categories = categoryRepository.findAll(pageable).getContent();
        } else {
            if (!StringUtils.isBlank(searchText) && statusType == null) {
                System.out.println("vafaf");
                count = categoryRepository.findByCategoryTypeContainingIgnoreCase(searchText).size();
                if (count == 0)
                    return new CategoryFetchResp(0, new ArrayList<>());
                categories = categoryRepository.findByCategoryTypeContainingIgnoreCase(searchText, pageable);
            } else if (StringUtils.isBlank(searchText) && statusType != null) {
                count = categoryRepository.findByStatusType(StatusType.findByValue(statusType)).size();
                if (count == 0)
                    return new CategoryFetchResp(0, new ArrayList<>());
                categories = categoryRepository.findByStatusType(StatusType.findByValue(statusType), pageable);
            } else {
                count = categoryRepository.findByCategoryTypeContainingIgnoreCaseAndStatusType(searchText, StatusType.findByValue(statusType)).size();
                if (count == 0)
                    return new CategoryFetchResp(0, new ArrayList<>());
                categories = categoryRepository.findByCategoryTypeContainingIgnoreCaseAndStatusType(searchText, StatusType.findByValue(statusType), pageable);
            }
        }

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> new CategoryDTO(category.getId(), category.getCategoryType(), category.getUpdated().toString(), category.getStatusType().getName()))
                .collect(Collectors.toList());
        return new CategoryFetchResp(count, categoryDTOS);
    }

    @Override
    public void changeStatusType(int id, int status) {
        categoryRepository.changeStatusType(id, StatusType.findByValue(status));
    }

    @Override
    public Category findCategory(int id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }
}
