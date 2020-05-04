package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.model.rest.response.category.CategoryFetchResp;
import com.entropy.backend.model.rest.response.category.CategoryGetResp;
import com.entropy.backend.model.rest.response.category.CategoryResp;
import com.entropy.backend.model.rest.response.error.ErrorResp;
import com.entropy.backend.service.CategoryService;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        List<CategoryGetResp> categoryGetResps = categoryService.findCategoryListEnable();
        return new ResponseEntity<>(categoryGetResps, HttpStatus.OK);
    }

    @GetMapping("/get-list")
    public ResponseEntity<?> findCategoryList(@RequestParam("sort") int sort, @RequestParam("limit") int limit, @RequestParam("start") int start, @RequestParam(name = "search_text", required = false) String searchText) {
        try {
            SortType.findByValue(sort);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        }

        if (limit < 0 || start < 0)
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        CategoryFetchResp fetchResp = categoryService.findCategories(sort, limit, start, searchText);
        return new ResponseEntity<>(fetchResp, HttpStatus.OK);
    }

    @PutMapping("/change-status/{id}/{status}")
    public ResponseEntity<?> changeStatusType(@PathVariable("id") int id, @PathVariable("status") int status) {
        try {
            StatusType.findByValue(status);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        }
        if (id <= 0)
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        categoryService.changeStatusType(id, status);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findCategory(@PathVariable("id") int id) {
        if (id <= 0)
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        Category category = categoryService.findCategory(id);
        if (category == null)
            return new ResponseEntity<>(new ErrorResp(APIMessage.CATEGORY_ID_NOT_EXIST), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
