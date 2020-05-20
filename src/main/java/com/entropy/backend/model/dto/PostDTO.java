package com.entropy.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostDTO {
    private int id;
    private String updated;
    private String author;
    private String title;
    @JsonProperty("publish_type")
    private String publishType;
    @JsonProperty("status_type")
    private String statusType;
}
