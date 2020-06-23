package com.entropy.backend.model.entity;

import com.entropy.backend.constant.QueryName;
import com.entropy.backend.enumeration.PublishType;
import com.entropy.backend.enumeration.StatusType;
import com.entropy.backend.model.dto.PostDTO;
import com.entropy.backend.model.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title"}))

@SqlResultSetMapping(name = QueryName.QUERY_POST, classes = {
        @ConstructorResult(targetClass = PostDTO.class,
                columns = {@ColumnResult(name = "post.id"), @ColumnResult(name = "post.updated", type = String.class),
                        @ColumnResult(name = "post.author", type = String.class), @ColumnResult(name = "post.title", type = String.class),
                        @ColumnResult(name = "post.publish_type", type = String.class), @ColumnResult(name = "post.status_type", type = String.class)
                })
})
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
    private PublishType publishType = PublishType.WAITTING;

}
