package com.entropy.backend.model.rest.response.post;

import com.entropy.backend.model.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostFetchResponse {
    private int count;
    private List<PostDTO> posts;
}
