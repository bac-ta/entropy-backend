package com.entropy.backend.repository.custom;

import com.entropy.backend.model.dto.PostDTO;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostDTO> findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText);
}
