package com.entropy.backend.service;

import com.entropy.backend.model.dto.PostFetchByIdDTO;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.model.rest.request.post.PostCreateReq;
import com.entropy.backend.model.rest.request.post.PostUpdateReq;
import com.entropy.backend.model.rest.response.post.PostFetchResp;
import com.entropy.backend.model.rest.response.post.PostSaveResp;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostFetchResp findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText);

    PostFetchByIdDTO findById(int id);

    Post createPost(PostCreateReq postReq);

    PostSaveResp updatePost(int id, PostUpdateReq req);

    void deletePost(int id);

    void changeStatusType(int id, int status);
}
