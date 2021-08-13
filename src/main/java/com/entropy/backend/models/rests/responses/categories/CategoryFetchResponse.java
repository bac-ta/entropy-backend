package com.entropy.backend.models.rests.responses.categories;

import com.entropy.backend.models.dtos.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryFetchResponse {
    private int count;
    private List<CategoryDto> categories;
}
