package com.entropy.backend.controller;

import com.entropy.backend.model.rest.response.file.FileResponse;
import com.entropy.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {
    private FileService service;

    @Autowired
    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping("/upload-file")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = service.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new FileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/upload-multiple-files")
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files).map(file -> uploadFile(file)).collect(Collectors.toList());
    }
}

