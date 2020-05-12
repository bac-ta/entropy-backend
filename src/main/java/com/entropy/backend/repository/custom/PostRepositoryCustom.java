package com.entropy.backend.repository.custom;

import com.entropy.backend.model.dto.PostDTO;

import java.util.List;
import java.util.Map;

public interface PostRepositoryCustom {
    Map<Integer, List<PostDTO>> findPosts(int sort, int start, int limit, Integer statusType, Integer publishType, Integer categoryId, String searchText);
}
