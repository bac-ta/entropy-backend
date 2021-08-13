package com.entropy.backend.repositories;

import com.entropy.backend.models.entities.Post;
import com.entropy.backend.repositories.customs.PostRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>, PostRepositoryCustom {

    Optional<Post> findById(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Post SET status=:status WHERE id=:id")
    void changePostStatus(int id, byte status);
}
