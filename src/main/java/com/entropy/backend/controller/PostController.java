package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.model.rest.request.post.PostCreateReq;
import com.entropy.backend.model.rest.response.error.ErrorResp;
import com.entropy.backend.model.rest.response.post.PostFetchResp;
import com.entropy.backend.model.rest.response.post.PostSaveResp;
import com.entropy.backend.service.PostService;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author bac-ta
 */

@RestController
@RequestMapping(APIEndpointBase.POST_ENDPOINT_BASE)
public class PostController {
    private PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/get-list")
    public ResponseEntity<?> findCategoryList(@RequestParam("sort") int sort, @RequestParam("limit") int limit, @RequestParam("start") int start,
                                              @RequestParam(name = "status_type", required = false) Integer statusType, @RequestParam(name = "publish_type", required = false) Integer publishType,
                                              @RequestParam(name = "category_id", required = false) Integer categoryId, @RequestParam(name = "search_text", required = false) String searchText) {
        try {
            SortType.findByValue(sort);
        } catch (ResourceNotFoundExceptionHandler e) {
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        }

        if (limit < 0 || start < 0)
            return new ResponseEntity<>(new ErrorResp(APIMessage.PARAMS_INVALID), HttpStatus.BAD_REQUEST);
        PostFetchResp fetchResp = service.findPosts(sort, limit, start, statusType, publishType, categoryId, searchText);
        return new ResponseEntity<>(fetchResp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> findPostById(@PathVariable("id") int id) {
        Optional<Post> optionalPost = service.findById(id);
        if (optionalPost.isPresent())
            return new ResponseEntity<>(optionalPost.get(), HttpStatus.OK);
        return new ResponseEntity<>(new Error(APIMessage.POST_ID_INVALID), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create")
    public ResponseEntity<PostSaveResp> createPost(@Valid @RequestBody PostCreateReq postReq) {
        Post post;
        try {
            post = service.createPost(postReq);
            if (post == null)
                return new ResponseEntity<>(new PostSaveResp(0, APIMessage.CREATE_POST_FAILURE), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(new PostSaveResp(post.getId(), APIMessage.CREATE_POST_SUCCESSFUL), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(new PostSaveResp(0, APIMessage.POST_TITLE_EXIST), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") int id) {
        service.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
