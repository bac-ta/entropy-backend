package com.entropy.backend.service;

import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateRequest;
import com.entropy.backend.model.rest.response.category.CategoryFetchResponse;
import com.entropy.backend.model.rest.response.category.CategoryGetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createCategory(CategoryCreateRequest request);

    List<CategoryGetResponse> findCategoryListEnable();

    CategoryFetchResponse findCategories(int sort, int limit, int start, Integer statusType, String searchText);

    void changeStatusType(int id, int status);

    Category findCategory(int id);
}
