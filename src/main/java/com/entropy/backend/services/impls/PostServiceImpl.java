package com.entropy.backend.services.impls;

import com.entropy.backend.models.dtos.PostDto;
import com.entropy.backend.models.entities.Post;
import com.entropy.backend.models.entities.PostCategory;
import com.entropy.backend.models.entities.PostTag;
import com.entropy.backend.models.enumerations.PublicationType;
import com.entropy.backend.models.enumerations.StatusType;
import com.entropy.backend.models.exceptions.PostFindNotFoundException;
import com.entropy.backend.models.rests.requests.posts.PostCreateRequest;
import com.entropy.backend.models.rests.requests.posts.PostUpdateRequest;
import com.entropy.backend.models.rests.responses.post.PostFetchResponse;
import com.entropy.backend.repositories.CategoryRepository;
import com.entropy.backend.repositories.PostCategoryRepository;
import com.entropy.backend.repositories.PostRepository;
import com.entropy.backend.repositories.PostTagRepository;
import com.entropy.backend.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * This class implement {@link PostService}
 *
 * @author bac-ta
 * @see PostServiceImpl
 * @since 2021-06-13
 */
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepo;
    private final AuthenticationServiceImpl authService;
    private final PostCategoryRepository postCategoryRepo;
    private final CategoryRepository categoryRepo;
    private final PostTagRepository postTagRepo;

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    public PostServiceImpl(PostRepository postRepo, AuthenticationServiceImpl authService, PostCategoryRepository postCategoryRepo, CategoryRepository categoryRepo, PostTagRepository postTagRepo) {
        this.postRepo = postRepo;
        this.authService = authService;
        this.postCategoryRepo = postCategoryRepo;
        this.categoryRepo = categoryRepo;
        this.postTagRepo = postTagRepo;
    }

    @Override
    public PostFetchResponse findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText) {
        logger.debug("Find posts");
        logger.info("sort: " + sort + ", start: " + start + ", limit: " + limit + ", status type: " + statusType +
                ", publish type: " + publishType + ", category id: " + categoryId + ", search text: " + searchText);

        Map<Integer, List<PostDto>> map = postRepo.findPosts(sort, start, limit, statusType, publishType, categoryId, searchText);
        Map.Entry<Integer, List<PostDto>> entry = map.entrySet().iterator().next();
        Integer count = entry.getKey();
        List<PostDto> postDtoList = entry.getValue();
        return new PostFetchResponse(count, postDtoList);
    }

    @Override
    @Transactional
    public void createPost(PostCreateRequest postRequest) {
        logger.debug("Creating post");
        logger.debug(postRequest.toString());

        String title = postRequest.getTitle();
        String content = postRequest.getContent();
        String imageTitleUrl = postRequest.getImageTitleUrl();
        String publication = postRequest.getPublication();
        PublicationType publicationType = PublicationType.valueOf(publication);
        String author = postRequest.getAuthor();

        //Save post
        Post post = new Post();
        post.setTitle(title);
        post.setImageTitleUrl(imageTitleUrl);
        post.setContent(content);
        post.setAuthor(author);
        post.setPublication((byte) publicationType.getValue());

        Post postCreated = postRepo.save(post);

        List<Map<Integer, List<Integer>>> mapCategoryTagIds = postRequest.getMapCategoryAndTagIds();

        List<PostCategory> postCategories = new ArrayList<>();
        List<PostTag> postTags = new ArrayList<>();

        mapCategoryTagIds.forEach(element -> element.forEach((categoryId, tagIds) -> {
            PostCategory pc = new PostCategory();
            pc.setPostId(postCreated.getId());
            pc.setCategoryId(categoryId);
            postCategories.add(pc);

            tagIds.forEach(tagId -> {
                PostTag pt = new PostTag();
                pt.setPostId(postCreated.getId());
                pt.setTagId(tagId);

                postTags.add(pt);
            });
        }));
        //Save post category
        postCategoryRepo.saveAll(postCategories);
        //Save post tag
        postTagRepo.saveAll(postTags);
    }

    @Override
    public void updatePost(int id, PostUpdateRequest postRequest) {
        logger.debug("Update post");
        logger.debug(postRequest.toString());

        Optional<Post> postOptional = postRepo.findById(id);
        if (!postOptional.isPresent())
            throw new PostFindNotFoundException(id);

        //Update post
        String title = postRequest.getTitle();
        String imageTitleUrl = postRequest.getImageTitleUrl();
        String content = postRequest.getContent();
        String author = postRequest.getAuthor();

        //
    }

    @Override
    public void deletePost(int id) {
        logger.debug("Delete post by id: " + id);

        Optional<Post> optionalPost = postRepo.findById(id);
        if (!optionalPost.isPresent())
            postRepo.changePostStatus(id, (byte) StatusType.OFF.getValue());
    }
}
