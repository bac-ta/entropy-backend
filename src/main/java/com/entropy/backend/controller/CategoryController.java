package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.model.dto.CategoryDTO;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.model.rest.response.category.CategoryGetResp;
import com.entropy.backend.model.rest.response.category.CategoryResp;
import com.entropy.backend.model.rest.response.error.ErrorResp;
import com.entropy.backend.service.CategoryService;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIEndpointBase.CATEGORY_ENDPOINT_BASE)
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResp> createCategory(@Valid @RequestBody CategoryCreateReq request) {
        try {
            Category category = categoryService.createCategory(request);
            return new ResponseEntity<>(new CategoryResp(category.getId(), APIMessage.CREATE_CATEGORY_SUCCESSFUL), HttpStatus.OK);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new CategoryResp(APIMessage.CREATE_CATEGORY_FAILURE + " cause: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-many")
    public ResponseEntity<List<CategoryGetResp>> findCategoryEnableList() {
        List<CategoryGetResp> categoryGetResps = categoryService.findCategoryListEnable().stream().map(category ->
                new CategoryGetResp(category.getId(), category.getCategoryType())).collect(Collectors.toList());
        return new ResponseEntity<>(categoryGetResps, HttpStatus.OK);
    }

    @GetMapping("/get-list")
    public ResponseEntity<?> findCategoryList(@Param("sort") int sort, @Param("limit") int limit, @Param("start") int start) {
        try {
            SortType.findByValue(sort);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        }

        if (limit <= 0 || start <= 0)
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        List<CategoryDTO> categoryDTOS = categoryService.findCategories(sort, limit, start).stream().
                map(category -> new CategoryDTO(category.getId(), category.getCategoryType(),
                        category.getUpdated().toString(), category.getStatusType().getName())).
                collect(Collectors.toList());
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }
}
