package com.entropy.backend.service;

import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.model.rest.response.category.CategoryFetchResp;
import com.entropy.backend.model.rest.response.category.CategoryGetResp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createCategory(CategoryCreateReq request);

    List<CategoryGetResp> findCategoryListEnable();

    CategoryFetchResp findCategories(int sort, int limit, int start, Integer statusType, String searchText);

    void changeStatusType(int id, int status);

    Category findCategory(int id);
}
