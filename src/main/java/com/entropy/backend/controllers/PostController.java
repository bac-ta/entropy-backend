package com.entropy.backend.controllers;

import com.entropy.backend.common.constants.ApiEndpointBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class controller for creates post APIs
 *
 * @author bac-ta
 * @see PostController
 * @since 2021-05-31
 */
@RestController
@RequestMapping(ApiEndpointBase.POST_URL_BASE)
public class PostController {
//    private final PostService postService;
//
//    @Autowired
//    public PostController(PostServiceImpl postService) {
//        this.postService = postService;
//    }
//
//    @GetMapping("/get-list")
//    public ResponseEntity<?> findPostList(@RequestParam("sort") int sort, @RequestParam("start") int start, @RequestParam("limit") int limit,
//                                          @RequestParam(name = "statusType", required = false) Integer statusType, @RequestParam(name = "publishType", required = false) Integer publishType,
//                                          @RequestParam(name = "categoryId", required = false) Integer categoryId, @RequestParam(name = "searchText", required = false) String searchText) {
//        try {
//            SortType.findByValue(sort);
//        } catch (ResourceNotFoundExceptionHandler e) {
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        }
//
//        if (limit < 0 || start < 0)
//            return new ResponseEntity<>(new ApiErrorResponse(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
//        PostFetchResponse fetchResp = postService.findPosts(sort, start, limit, statusType, publishType, categoryId, searchText);
//        return new ResponseEntity<>(fetchResp, HttpStatus.OK);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<PostFetchByIdDTO> findPostById(@PathVariable("id") int id) {
//        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<PostSaveResponse> createPost(@Valid @RequestBody PostCreateRequest postRequestuest) {
//        Post post;
//        try {
//            post = postService.createPost(postRequest);
//            if (post == null)
//                return new ResponseEntity<>(new PostSaveResponse(0, APIMessage.CREATE_POST_FAILURE), HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<>(new PostSaveResponse(post.getId(), APIMessage.CREATE_POST_SUCCESSFUL), HttpStatus.OK);
//        } catch (DataIntegrityViolationException e) {
//            return new ResponseEntity<>(new PostSaveResponse(0, APIMessage.POST_TITLE_EXIST), HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deletePost(@PathVariable("id") int id) {
//        postService.deletePost(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
//        postService.changeStatusType(id, status);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<PostSaveResponse> updatePost(@PathVariable("id") int id, @Valid @RequestBody PostUpdateRequest postRequest) throws ResourceNotFoundExceptionHandler {
//        PostSaveResponse saveResp = postService.updatePost(id, postRequest);
//        return new ResponseEntity<>(saveResp, HttpStatus.OK);
//    }
}
