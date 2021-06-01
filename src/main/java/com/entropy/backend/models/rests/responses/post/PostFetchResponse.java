package com.entropy.backend.models.rests.responses.post;

import com.entropy.backend.models.dtos.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostFetchResponse {
    private int count;
    private List<PostDTO> posts;
}
