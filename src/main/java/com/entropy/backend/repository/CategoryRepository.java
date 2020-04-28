package com.entropy.backend.repository;

import com.entropy.backend.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStatusType(String statusType);

    @Query(value = "FROM Category ORDER BY id ?1 LIMIT ?2,?3")
    List<Category> findCategories(String sort, int limit, int start);
}
