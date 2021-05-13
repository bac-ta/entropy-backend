package com.entropy.backend.model.rest.response.category;

import com.entropy.backend.model.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryFetchResponse {
    private int count;
    private List<CategoryDTO> categories;
}
