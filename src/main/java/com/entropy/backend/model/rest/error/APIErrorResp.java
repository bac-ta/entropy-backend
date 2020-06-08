package com.entropy.backend.model.rest.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class APIErrorResp {
    private List<String> errors;

}
