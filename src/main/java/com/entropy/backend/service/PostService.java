package com.entropy.backend.service;

import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.enumeration.PublishType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.CategoryDTO;
import com.entropy.backend.model.dto.PostFetchByIdDTO;
import com.entropy.backend.model.entity.Category;
import com.entropy.backend.repository.CategoryRepository;
import com.entropy.backend.security.jwt.AccountPrincipal;
import com.entropy.backend.model.dto.PostDTO;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.model.entity.PostCategory;
import com.entropy.backend.model.rest.request.post.PostCreateReq;
import com.entropy.backend.model.rest.response.post.PostFetchResp;
import com.entropy.backend.repository.PostCategoryRepository;
import com.entropy.backend.repository.PostRepository;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
    private CategoryRepository categoryRepo;
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    public PostService(PostRepository postRepo, AuthenticationService authService, PostCategoryRepository postCategoryRepo, CategoryRepository categoryRepo) {
        this.postRepo = postRepo;
        this.authService = authService;
        this.postCategoryRepo = postCategoryRepo;
        this.categoryRepo = categoryRepo;
    }

    public PostFetchResp findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText) {
        logger.debug("Find posts");
        logger.info("sort: " + sort + ", start: " + start + ", limit: " + limit + ", status type: " + statusType +
                ", publish type: " + publishType + ", category id: " + categoryId + ", search text: " + searchText);

        Map<Integer, List<PostDTO>> map = postRepo.findPosts(sort, start, limit, statusType, publishType, categoryId, searchText);
        Map.Entry<Integer, List<PostDTO>> entry = map.entrySet().iterator().next();
        Integer count = entry.getKey();
        List<PostDTO> postDTOList = entry.getValue();
        return new PostFetchResp(count, postDTOList);
    }

    public PostFetchByIdDTO findById(int id) {
        logger.debug("Find post by id: " + id);

        Optional<Post> optionalPost = postRepo.findById(id);
        if (!optionalPost.isPresent())
            throw new ResourceNotFoundExceptionHandler(APIMessage.POST_NOT_FOUND);

        Post post = optionalPost.get();
        PostFetchByIdDTO postDTO = new PostFetchByIdDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setAuthor(post.getAuthor());
        postDTO.setUpdated(post.getUpdated().toString());
        postDTO.setPublishType(post.getPublishType().name());
        postDTO.setStatusType(post.getStatusType().name());

        List<PostCategory> postCategories = postCategoryRepo.findByPostId(post.getId());
        List<Integer> categoryIds = postCategories.stream().map(PostCategory::getCategoryId).collect(Collectors.toList());
        List<Category> categories = categoryRepo.findByIdIn(categoryIds);
        List<CategoryDTO> categoryDTOList = categories.stream().map(category -> new CategoryDTO(category.getId(), category.getCategoryType(), category.getUpdated().toString(), category.getStatusType().name())).collect(Collectors.toList());

        postDTO.setCategoryDTOInfoList(categoryDTOList);
        return postDTO;

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
        post.setPublishType(PublishType.findByValue(postReq.getPublishType()));

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

        Optional<Post> optionalPost = postRepo.findById(id);
        if (!optionalPost.isPresent())
            postRepo.updatePostStatus(id, StatusType.OFF);
    }

    public void changeStatusType(int id, int status) {
        logger.debug("Change post status type by id: " + id);
        postRepo.changeStatusType(id, StatusType.findByValue(status));
    }

}
