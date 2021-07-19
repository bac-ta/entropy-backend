package com.entropy.backend.controllers;

import com.entropy.backend.common.constants.ApiEndpointBase;
import com.entropy.backend.common.constants.ApiMessage;
import com.entropy.backend.models.rests.responses.file.FileResponse;
import com.entropy.backend.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class controller for creates file APIs
 *
 * @author bac-ta
 * @see FileController
 * @since 2021-05-31
 */
@RestController
@RequestMapping(ApiEndpointBase.FILE_URL_BASE)
public class FileController {
    private final FileService service;
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    public FileController(FileService service) {
        this.service = service;
    }

    @PostMapping("/upload-file")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = service.storeFile(file);

        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(ApiEndpointBase.FILE_URL_BASE + "/view-file/")
                .path(fileName)
                .toUriString();

        return new FileResponse(fileName, fileUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/upload-multiple-files")
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files).map(this::uploadFile).collect(Collectors.toList());
    }

    @GetMapping("/view-file/{fileName:.+}")
    public ResponseEntity<Resource> viewFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = service.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info(ApiMessage.NOT_DETERMINE_FILE_TYPE);
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
        // If need download file add more : header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
    }
}

