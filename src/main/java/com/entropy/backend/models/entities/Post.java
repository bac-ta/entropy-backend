package com.entropy.backend.models.entities;

import com.entropy.backend.models.entities.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ofPost")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post extends Base {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "imageTitle")
    private String imageTitle;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "author")
    private String author;

    @Column
    private Byte publication;

    @Column(name = "status")
    private Byte status;
}
