package com.entropy.backend.repository;

import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Optional<Post> findById(int id);

    @Query("UPDATE Post SET statusType=:statusType WHERE id=:id")
    void updatePostStatus(int id, StatusType statusType);

    List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String searchText, Pageable pageable);

    List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String searchText);
}
