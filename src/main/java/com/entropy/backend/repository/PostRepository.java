package com.entropy.backend.repository;

import com.entropy.backend.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPosts(Pageable pageable);

    Optional<Post> findById(int id);
}
