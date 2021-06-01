package com.entropy.backend.services;

import com.entropy.backend.models.entities.Category;
import com.entropy.backend.models.rests.requests.categories.CategoryCreateRequest;
import com.entropy.backend.models.rests.responses.categories.CategoryFetchResponse;
import com.entropy.backend.models.rests.responses.categories.CategoryGetResponse;
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
