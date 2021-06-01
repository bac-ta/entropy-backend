package com.entropy.backend.services;

import com.entropy.backend.models.dtos.PostFetchByIdDTO;
import com.entropy.backend.models.entities.Post;
import com.entropy.backend.models.rests.requests.posts.PostCreateRequest;
import com.entropy.backend.models.rests.requests.posts.PostUpdateRequest;
import com.entropy.backend.models.rests.responses.post.PostFetchResponse;
import com.entropy.backend.models.rests.responses.post.PostSaveResponse;
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
