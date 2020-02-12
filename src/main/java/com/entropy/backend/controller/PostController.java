package com.entropy.backend.controller;

import com.entropy.backend.constant.APIEndpointBase;
import com.entropy.backend.entity.Post;
import com.entropy.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
