package com.entropy.backend.service;

import com.entropy.backend.model.dto.PostFetchByIdDTO;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.model.rest.request.post.PostCreateRequest;
import com.entropy.backend.model.rest.request.post.PostUpdateRequest;
import com.entropy.backend.model.rest.response.post.PostFetchResponse;
import com.entropy.backend.model.rest.response.post.PostSaveResponse;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostFetchResponse findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText);

    PostFetchByIdDTO findById(int id);

    Post createPost(PostCreateRequest postReq);

    PostSaveResponse updatePost(int id, PostUpdateRequest req);

    void deletePost(int id);

    void changeStatusType(int id, int status);
}
