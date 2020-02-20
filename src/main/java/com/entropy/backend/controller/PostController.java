package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.entity.Post;
import com.entropy.backend.enumeration.CategoryType;
import com.entropy.backend.rest.request.PostCreateReq;
import com.entropy.backend.rest.response.PostSaveResp;
import com.entropy.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findPosts(@RequestParam("start") int start, @RequestParam("limit") int limit) {
        List<Post> posts = service.findPosts(start, limit);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<Object> findPostById(@RequestParam("id") int id) {
        Optional<Post> optionalPost = service.findById(id);
        if (optionalPost.isPresent())
            return new ResponseEntity<>(optionalPost.get(), HttpStatus.OK);
        return new ResponseEntity<>(new Error(APIMessage.POST_ID_INVALID), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> createPost(@Valid @RequestBody PostCreateReq postReq) {
        Post post = service.createPost(postReq);
        if (post == null)
            return new ResponseEntity<>(new Error(APIMessage.CREATE_POST_FAIL), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new PostSaveResp(post.getId(), APIMessage.CREATE_POST_SUCCESSFUL), HttpStatus.OK);

    }
}
