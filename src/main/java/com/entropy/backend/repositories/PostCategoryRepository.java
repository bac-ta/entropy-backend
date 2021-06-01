package com.entropy.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {
    List<PostCategory> findByPostId(int postId);

    void deleteByPostIdAndCategoryIdIn(int postId, List<Integer> categoryIds);
}
