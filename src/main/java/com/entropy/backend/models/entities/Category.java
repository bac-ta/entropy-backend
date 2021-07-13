package com.entropy.backend.models.entities;

import com.entropy.backend.models.entities.base.Base;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ofCategory")
@Data
@AllArgsConstructor
public class Category extends Base {
    @Id
    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Byte status;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Set<Post> posts;


    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Tag.class)
    @JoinTable(
            name = "ofCategoryTag",
            joinColumns = @JoinColumn(name = "categoryId"),
            inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    private Set<Tag> tags = new HashSet<>();
}
