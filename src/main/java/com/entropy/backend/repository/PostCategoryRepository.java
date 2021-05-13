package com.entropy.backend.repository;

import com.entropy.backend.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {
    List<PostCategory> findByPostId(int postId);

    void deleteByPostIdAndCategoryIdIn(int postId, List<Integer> categoryIds);
}
