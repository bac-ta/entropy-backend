package com.entropy.backend.repository;

import com.entropy.backend.model.enumeration.StatusType;
import com.entropy.backend.model.entity.Post;
import com.entropy.backend.repository.custom.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer>, PostRepositoryCustom {

    Optional<Post> findById(int id);

    @Query("UPDATE Post SET statusType=:statusType WHERE id=:id")
    void updatePostStatus(int id, StatusType statusType);

    @Transactional
    @Modifying
    @Query("UPDATE Post SET statusType=:statusType WHERE id=:id")
    void changeStatusType(int id, StatusType statusType);
}
