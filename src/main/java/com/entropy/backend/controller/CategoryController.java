package com.entropy.backend.controller;

import com.entropy.backend.common.constant.APIEndpointBase;
import com.entropy.backend.common.constant.APIMessage;
import com.entropy.backend.model.enumeration.SortType;
import com.entropy.backend.model.enumeration.StatusType;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateRequest;
import com.entropy.backend.model.rest.response.category.CategoryFetchResponse;
import com.entropy.backend.model.rest.response.category.CategoryGetResponse;
import com.entropy.backend.model.rest.response.category.CategoryResponse;
import com.entropy.backend.model.rest.response.error.ErrorResponse;
import com.entropy.backend.service.CategoryService;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(APIEndpointBase.CATEGORY_ENDPOINT_BASE)
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryCreateRequest request) {
        try {
            Category category = categoryService.createCategory(request);
            return new ResponseEntity<>(new CategoryResponse(category.getId(), APIMessage.CREATE_CATEGORY_SUCCESSFUL), HttpStatus.OK);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new CategoryResponse(APIMessage.CREATE_CATEGORY_FAILURE + " cause: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-many")
    public ResponseEntity<List<CategoryGetResponse>> findCategoryEnableList() {
        List<CategoryGetResponse> categoryGetResponses = categoryService.findCategoryListEnable();
        return new ResponseEntity<>(categoryGetResponses, HttpStatus.OK);
    }

    @GetMapping("/get-list")
    public ResponseEntity<?> findCategoryList(@RequestParam("sort") int sort, @RequestParam("limit") int limit, @RequestParam("start") int start, @RequestParam(name = "status_type", required = false) Integer statusType, @RequestParam(name = "search_text", required = false) String searchText) {
        try {
            SortType.findByValue(sort);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new ErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        }

        if (limit < 0 || start < 0)
            return new ResponseEntity<>(new ErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        CategoryFetchResponse fetchResp = categoryService.findCategories(sort, limit, start, statusType, searchText);
        return new ResponseEntity<>(fetchResp, HttpStatus.OK);
    }

    @PutMapping("/change-status/{id}/{status}")
    public ResponseEntity<?> changeStatusType(@PathVariable("id") int id, @PathVariable("status") int status) {
        try {
            StatusType.findByValue(status);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new ErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        }
        if (id <= 0)
            return new ResponseEntity<>(new ErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        categoryService.changeStatusType(id, status);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findCategory(@PathVariable("id") int id) {
        if (id <= 0)
            return new ResponseEntity<>(new ErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        Category category = categoryService.findCategory(id);
        if (category == null)
            return new ResponseEntity<>(new ErrorResponse(APIMessage.CATEGORY_ID_NOT_EXIST), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
