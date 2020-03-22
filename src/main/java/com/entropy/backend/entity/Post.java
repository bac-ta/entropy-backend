package com.entropy.backend.entity;

import com.entropy.backend.entity.base.Base;
import com.entropy.backend.enumeration.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Post extends Base {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;
    @Column(name = "category_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CategoryType categoryType;
    @Column
    private String author;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
