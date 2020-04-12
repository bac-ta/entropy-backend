package com.entropy.backend.model.entity;

import com.entropy.backend.model.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCategory extends Base {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "category_id")
    private Integer categoryId;
}
