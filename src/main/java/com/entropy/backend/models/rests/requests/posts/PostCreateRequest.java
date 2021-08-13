package com.entropy.backend.models.rests.requests.posts;

import com.entropy.backend.models.anonations.PublicationVerifier;
import com.entropy.backend.models.anonations.URLVerifier;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@ToString
@AllArgsConstructor

public class PostCreateRequest {
    @NotBlank
    @JsonProperty(required = true)
    private String title;
    @NotBlank
    @JsonProperty(required = true)
    @URLVerifier
    private String imageTitleUrl;
    @NotBlank
    @JsonProperty(required = true)
    private String content;
    @NotBlank
    @JsonProperty(required = true)
    private String author;
    @NotEmpty
    @JsonProperty(required = true)
    private List<Map<Integer, List<Integer>>> mapCategoryAndTagIds;
    @NotNull
    @JsonProperty(required = true)
    @PublicationVerifier
    private String publication;
}
