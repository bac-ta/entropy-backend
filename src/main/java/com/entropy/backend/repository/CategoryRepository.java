package com.entropy.backend.repository;

import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStatusType(StatusType statusType);

    @Transactional
    @Modifying
    @Query("UPDATE Category SET statusType=:statusType WHERE id=:id")
    void changeStatusType(int id, StatusType statusType);

    Optional<Category> findById(int id);

    List<Category> findByCategoryTypeContainingIgnoreCase(String categoryType, Pageable pageable);
    List<Category> findByCategoryTypeContainingIgnoreCase(String categoryType);
}
