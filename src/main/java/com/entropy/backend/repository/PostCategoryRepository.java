package com.entropy.backend.repository;

import com.entropy.backend.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {
    List<PostCategory> findByPostId(int postId);
}
