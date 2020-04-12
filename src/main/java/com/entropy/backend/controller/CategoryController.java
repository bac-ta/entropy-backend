package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.model.rest.request.category.CategoryCreateReq;
import com.entropy.backend.model.rest.response.category.CategoryGetResp;
import com.entropy.backend.model.rest.response.category.CategoryResp;
import com.entropy.backend.service.CategoryService;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryGetResp>> findCategoryList() {
        List<CategoryGetResp> categoryGetResps = categoryService.findCategoryList().stream().map(category ->
                new CategoryGetResp(category.getId(), category.getCategoryType())).collect(Collectors.toList());
        return new ResponseEntity<>(categoryGetResps, HttpStatus.OK);
    }
}
