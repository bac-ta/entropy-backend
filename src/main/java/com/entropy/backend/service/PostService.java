package com.entropy.backend.service;

import com.entropy.backend.enumeration.PublishStype;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.model.entity.PostCategory;
import com.entropy.backend.model.rest.request.post.PostCreateReq;
import com.entropy.backend.repository.PostCategoryRepository;
import com.entropy.backend.repository.PostRepository;
import com.entropy.backend.security.jwt.AccountPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author bac-ta
 */
@Service
public class PostService {
    private PostRepository postRepo;
    private AuthenticationService authService;
    private PostCategoryRepository postCategoryRepo;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    public PostService(PostRepository postRepo, AuthenticationService authService, PostCategoryRepository postCategoryRepo) {
        this.postRepo = postRepo;
        this.authService = authService;
        this.postCategoryRepo = postCategoryRepo;
    }

    public List<Post> findPosts(int start, int limit) {
        logger.debug("Find posts");
        logger.info("start: " + start + ", limit: " + limit);

        Pageable pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.DESC, "created"));
        return (List<Post>) postRepo.findAll(pageable);
    }

    public Optional<Post> findById(int id) {
        logger.debug("Find post by id: " + id);

        Optional<Post> optionalPost = postRepo.findById(id);
        return optionalPost;
    }

    public Post createPost(PostCreateReq postReq) {
        logger.debug("Create post");
        logger.debug(postReq.toString());

        String title = postReq.getTitle();
        String content = postReq.getContent();
        //Save post
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setPublishStype(PublishStype.findByValue(postReq.getPublishType()));

        AccountPrincipal principal = authService.getCurrentPrincipal();
        post.setAuthor(principal.getUsername());
        post.setUserId(Integer.parseInt(principal.getId().toString()));

        Post postCreated = postRepo.save(post);

        //Save post category
        List<Integer> categoryIds = postReq.getCategoryIds();

        List<PostCategory> postCategories = categoryIds.stream().map(categoryId -> {
            PostCategory postCategory = new PostCategory();
            postCategory.setPostId(postCreated.getId());
            postCategory.setCategoryId(categoryId);
            return postCategory;
        }).collect(Collectors.toList());

        postCategoryRepo.saveAll(postCategories);

        return postCreated;
    }

    public void deletePost(int id) {
        logger.debug("Delete post by id: " + id);

        Optional<Post> optionalPost = findById(id);
        if (!optionalPost.isPresent())
            postRepo.updatePostStatus(id, StatusType.OFF);
    }
}
