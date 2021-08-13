package com.entropy.backend.services;

import com.entropy.backend.models.rests.requests.posts.PostCreateRequest;
import com.entropy.backend.models.rests.requests.posts.PostUpdateRequest;
import com.entropy.backend.models.rests.responses.post.PostFetchResponse;

/**
 * Interface provide methods handle post
 *
 * @author bac-ta
 * @see PostService
 * @since 2021-06-13
 */
public interface PostService {
    PostFetchResponse findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText);

    void createPost(PostCreateRequest postRequest);

    void updatePost(int id, PostUpdateRequest req);

    void deletePost(int id);
}
