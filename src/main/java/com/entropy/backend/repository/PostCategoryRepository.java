package com.entropy.backend.repository;

import com.entropy.backend.model.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {
}
