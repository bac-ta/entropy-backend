package com.entropy.backend.service;

import com.entropy.backend.constant.APIMessage;
import com.entropy.backend.enumeration.FileType;
import com.entropy.backend.model.property.FileStorageProperties;
import com.entropy.backend.util.ResourceNotFoundExceptionHandler;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileService {
    private final Path fileStorageLocation;

    @Autowired
    public FileService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
            throw new ResourceNotFoundExceptionHandler(APIMessage.CREATE_FILEDIR_ERROR, e);
        }
    }

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains(".."))
                throw new ResourceNotFoundExceptionHandler(APIMessage.FILE_INVALID_PATH_SEQUENCE + fileName);

            String fileTypeStr = FilenameUtils.getExtension(file.getOriginalFilename());

            //Check file type
            FileType.findByName(fileTypeStr);

            UUID uuid = UUID.randomUUID();

            String fileNameGen = uuid.toString().concat(".").concat(fileTypeStr);
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileNameGen);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileNameGen;
        } catch (IOException ex) {
            throw new ResourceNotFoundExceptionHandler(String.format(APIMessage.FILE_NOT_STORE, fileName), ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new ResourceNotFoundExceptionHandler(String.format(APIMessage.FILE_NOT_FOUND, fileName));
            }
        } catch (MalformedURLException e) {
            throw new ResourceNotFoundExceptionHandler(String.format(APIMessage.FILE_NOT_FOUND, fileName), e);
        }
    }
}
