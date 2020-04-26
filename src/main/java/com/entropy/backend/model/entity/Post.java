package com.entropy.backend.model.entity;

import com.entropy.backend.enumeration.PublishStype;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
    @Column(name = "image_title", nullable = false)
    private String imageTitle;
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;
    @Column
    private String author;
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Column(name = "status_type", columnDefinition = "VARCHAR(45) DEFAULT 'ON'", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StatusType statusType = StatusType.ON;
    @Column(name = "publish_type", columnDefinition = "VARCHAR(45) DEFAULT 'WATTING'", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PublishStype publishStype = PublishStype.WAITTING;

}
