package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.enumerations.PublishType;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.dtos.CategoryDTO;
import com.entropy.backend.models.dtos.PostDTO;
import com.entropy.backend.models.dtos.PostFetchByIdDTO;
import com.entropy.backend.models.rests.requests.posts.PostCreateRequest;
import com.entropy.backend.models.rests.requests.posts.PostUpdateRequest;
import com.entropy.backend.models.rests.responses.post.PostFetchResponse;
import com.entropy.backend.models.rests.responses.post.PostSaveResponse;
import com.entropy.backend.repositories.CategoryRepository;
import com.entropy.backend.repositories.PostCategoryRepository;
import com.entropy.backend.repositories.PostRepository;
import com.entropy.backend.configurations.securities.jwts.AccountPrincipal;
import com.entropy.backend.services.PostService;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
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
public class PostServiceImpl implements PostService {
    private PostRepository postRepo;
    private AuthenticationServiceImpl authService;
    private PostCategoryRepository postCategoryRepo;
    private CategoryRepository categoryRepo;
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    public PostServiceImpl(PostRepository postRepo, AuthenticationServiceImpl authService, PostCategoryRepository postCategoryRepo, CategoryRepository categoryRepo) {
        this.postRepo = postRepo;
        this.authService = authService;
        this.postCategoryRepo = postCategoryRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public PostFetchResponse findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText) {
        logger.debug("Find posts");
        logger.info("sort: " + sort + ", start: " + start + ", limit: " + limit + ", status type: " + statusType +
                ", publish type: " + publishType + ", category id: " + categoryId + ", search text: " + searchText);

        Map<Integer, List<PostDTO>> map = postRepo.findPosts(sort, start, limit, statusType, publishType, categoryId, searchText);
        Map.Entry<Integer, List<PostDTO>> entry = map.entrySet().iterator().next();
        Integer count = entry.getKey();
        List<PostDTO> postDTOList = entry.getValue();
        return new PostFetchResponse(count, postDTOList);
    }

    @Override
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
        postDTO.setImageTitle(post.getImageTitle());

        List<PostCategory> postCategories = postCategoryRepo.findByPostId(post.getId());
        List<Integer> categoryIds = postCategories.stream().map(PostCategory::getCategoryId).collect(Collectors.toList());
        List<Category> categories = categoryRepo.findByIdIn(categoryIds);
        List<CategoryDTO> categoryDTOList = categories.stream().map(category -> new CategoryDTO(category.getId(), category.getCategoryType(), category.getUpdated().toString(), category.getStatusType().name())).collect(Collectors.toList());

        postDTO.setCategoryDTOInfoList(categoryDTOList);
        return postDTO;

    }

    @Override
    public Post createPost(PostCreateRequest postReq) {
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

    @Override
    public PostSaveResponse updatePost(int id, PostUpdateRequest req) {
        logger.debug("Update post");
        logger.debug(req.toString());

        //Update post
        String title = req.getTitle();
        String imageTitle = req.getImageTitle();
        String content = req.getContent();
        PublishType publishType = PublishType.findByValue(req.getPublishType());
        StatusType statusType = StatusType.findByValue(req.getStatusType());

        Optional<Post> postOptional = postRepo.findById(id);
        Post post = postOptional.get();
        post.setTitle(title);
        post.setImageTitle(imageTitle);
        post.setContent(content);
        post.setPublishType(publishType);
        post.setStatusType(statusType);

        List<Integer> categoryUseIds = req.getCategoryUseIds();
        if (categoryUseIds.isEmpty())
            return new PostSaveResponse(id, APIMessage.UPDATE_POST_SUCCESSFUL);

        List<PostCategory> postCategoriesStore = postCategoryRepo.findByPostId(id);
        List<Integer> categoryStoreNotUseIds = postCategoriesStore.stream().filter(postCategory ->
                !categoryUseIds.contains(postCategory.getCategoryId())
        ).map(postCategory -> postCategory.getCategoryId()).collect(Collectors.toList());

        if (!categoryStoreNotUseIds.isEmpty()) {
            //delete post category not use
            postCategoryRepo.deleteByPostIdAndCategoryIdIn(id, categoryStoreNotUseIds);
        }
        List<Integer> categoryStoreUseIds = postCategoriesStore.stream().filter(postCategory ->
                categoryUseIds.contains(postCategory.getCategoryId()))
                .map(postCategory -> postCategory.getCategoryId()).collect(Collectors.toList());

        //Remove
        categoryUseIds.removeAll(categoryStoreUseIds);
        //save new

        List<PostCategory> postCategoriesNewUse = categoryUseIds.stream().map(categoryId -> {
            PostCategory postCategory = new PostCategory();
            postCategory.setPostId(id);
            postCategory.setCategoryId(categoryId);
            return postCategory;
        }).collect(Collectors.toList());

        postCategoryRepo.saveAll(postCategoriesNewUse);

        return new PostSaveResponse(id, APIMessage.UPDATE_POST_SUCCESSFUL);
    }

    @Override
    public void deletePost(int id) {
        logger.debug("Delete post by id: " + id);

        Optional<Post> optionalPost = postRepo.findById(id);
        if (!optionalPost.isPresent())
            postRepo.updatePostStatus(id, StatusType.OFF);
    }

    @Override
    public void changeStatusType(int id, int status) {
        logger.debug("Change post status type by id: " + id);
        postRepo.changeStatusType(id, StatusType.findByValue(status));
    }

}
