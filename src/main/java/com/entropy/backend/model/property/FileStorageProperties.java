package com.entropy.backend.model.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileStorageProperties {
    @Value("${app.file.upload-dir}")
    private String uploadDir;
}
