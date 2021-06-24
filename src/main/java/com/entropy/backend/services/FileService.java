package com.entropy.backend.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface provide methods handle file
 *
 * @author bac-ta
 * @see FileService
 * @since 2021-06-22
 */
public interface FileService {
    String storeFile(MultipartFile file);

    Resource loadFileAsResource(String fileName);
}
