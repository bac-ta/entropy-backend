package com.entropy.backend.models.rests.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor

@Data
public class GlobalExceptionResponse {
    private List<String> errors;
}
