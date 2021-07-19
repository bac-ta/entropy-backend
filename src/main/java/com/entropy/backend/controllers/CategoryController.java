package com.entropy.backend.controllers;

import com.entropy.backend.common.constants.ApiEndpointBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class controller for creates category APIs
 *
 * @author bac-ta
 * @see CategoryController
 * @since 2021-05-31
 */
@RestController
@RequestMapping(ApiEndpointBase.CATEGORY_URL_BASE)
public class CategoryController {
//    private final CategoryService categoryService;
//
//    @Autowired
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryCreateRequest request) {
//        try {
//            Category category = categoryService.createCategory(request);
//            return new ResponseEntity<>(new CategoryResponse(category.getId(), APIMessage.CREATE_CATEGORY_SUCCESSFUL), HttpStatus.OK);
//        } catch (ResourceNotFoundExceptionHandler e) {
//            return new ResponseEntity<>(new CategoryResponse(APIMessage.CREATE_CATEGORY_FAILURE + " cause: " + e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/get-many")
//    public ResponseEntity<List<CategoryGetResponse>> findCategoryEnableList() {
//        List<CategoryGetResponse> categoryGetResponses = categoryService.findCategoryListEnable();
//        return new ResponseEntity<>(categoryGetResponses, HttpStatus.OK);
//    }
//
//    @GetMapping("/get-list")
//    public ResponseEntity<?> findCategoryList(@RequestParam("sort") int sort, @RequestParam("limit") int limit, @RequestParam("start") int start, @RequestParam(name = "status_type", required = false) Integer statusType, @RequestParam(name = "search_text", required = false) String searchText) {
//        try {
//            SortType.findByValue(sort);
//        } catch (ResourceNotFoundExceptionHandler e) {
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        }
//
//        if (limit < 0 || start < 0)
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        CategoryFetchResponse fetchResp = categoryService.findCategories(sort, limit, start, statusType, searchText);
//        return new ResponseEntity<>(fetchResp, HttpStatus.OK);
//    }
//
//    @PutMapping("/change-status/{id}/{status}")
//    public ResponseEntity<?> changeStatusType(@PathVariable("id") int id, @PathVariable("status") int status) {
//        try {
//            StatusType.findByValue(status);
//        } catch (ResourceNotFoundExceptionHandler e) {
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        }
//        if (id <= 0)
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        categoryService.changeStatusType(id, status);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<?> findCategory(@PathVariable("id") int id) {
//        if (id <= 0)
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        Category category = categoryService.findCategory(id);
//        if (category == null)
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.CATEGORY_ID_NOT_EXIST), HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(category, HttpStatus.OK);
//    }
}
