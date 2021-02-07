package com.entropy.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
    String storeFile(MultipartFile file);
    Resource loadFileAsResource(String fileName);

}
