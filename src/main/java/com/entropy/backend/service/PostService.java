package com.entropy.backend.service;

import com.entropy.backend.enumeration.PublishStype;
import com.entropy.backend.enumeration.SortType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.PostDTO;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.model.entity.PostCategory;
import com.entropy.backend.model.rest.request.post.PostCreateReq;
import com.entropy.backend.model.rest.response.post.PostFetchResp;
import com.entropy.backend.repository.PostCategoryRepository;
import com.entropy.backend.repository.PostRepository;
import com.entropy.backend.security.jwt.AccountPrincipal;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public PostFetchResp findPosts(int sort, int start, int limit, String searchText) {
        logger.debug("Find posts");
        logger.info("sort: " + sort + ", start: " + start + ", limit: " + limit + ", search text: " + searchText);
        Pageable pageable = null;

        if (SortType.findByValue(sort) == SortType.ASC)
            pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.ASC, "id"));
        else if (SortType.findByValue(sort) == SortType.DESC)
            pageable = PageRequest.of(start, limit, Sort.by(Sort.Direction.DESC, "id"));

        int count;
        List<Post> posts;

        if (StringUtils.isBlank(searchText)) {
            count = postRepo.findAll().size();
            if (count == 0)
                return new PostFetchResp(0, new ArrayList<>());
            posts = postRepo.findAll(pageable).getContent();
        } else {
            count = postRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(searchText).size();
            if (count == 0)
                return new PostFetchResp(0, new ArrayList<>());

            posts = postRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(searchText, pageable);
        }

        List<PostDTO> postDTOS = posts.stream()
                .map(post -> new PostDTO(post.getId(), post.getUpdated().toString(), post.getAuthor(), post.getImageTitle(),
                        post.getTitle(), post.getPublishStype().getName(), post.getStatusType().getName()))
                .collect(Collectors.toList());
        return new PostFetchResp(count, postDTOS);
    }

    public Optional<Post> findById(int id) {
        logger.debug("Find post by id: " + id);

        return postRepo.findById(id);
    }

    public Post createPost(PostCreateReq postReq) {
        logger.debug("Create post");
        logger.debug(postReq.toString());

        String title = postReq.getTitle();
        String content = postReq.getContent();
        String imageTitle = postReq.getImageTitle();
        //Save post
        Post post = new Post();
        post.setTitle(title);
        post.setImageTitle(imageTitle);
        post.setContent(content);
        post.setPublishStype(PublishStype.findByValue(postReq.getPublishType()));

        AccountPrincipal principal = authService.getCurrentPrincipal();
        post.setAuthor(principal.getUsername());
        post.setUserId(Integer.parseInt(principal.getId().toString()));

        Post postCreated = postRepo.save(post);

        //Save post category
        List<Integer> categoryIds = postReq.getCategoryIds();
        if (categoryIds.isEmpty())
            return postCreated;

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
