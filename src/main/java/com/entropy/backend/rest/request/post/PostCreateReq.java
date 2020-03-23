package com.entropy.backend.rest.request.post;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PostCreateReq {
    @Column
    private String title;
    @Column
    private String content;
    @Column(name = "category_type")
    private Integer categoryType;
    @Column
    private String author;
    private Integer publishType;
}
