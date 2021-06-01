package com.entropy.backend.services.impls;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.models.enumerations.FileType;
import com.entropy.backend.models.properties.FileStorageProperties;
import com.entropy.backend.services.FileService;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    private final Path fileStorageLocation;
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    public FileServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ResourceNotFoundExceptionHandler(APIMessage.CREATE_FILEDIR_ERROR, e);
        }
    }

    @Override
    public String storeFile(MultipartFile file) {
        logger.info("Store file");
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
            logger.info("uuid:" + uuid.toString());

            String fileNameGen = uuid.toString().concat(".").concat(fileTypeStr);
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileNameGen);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileNameGen;
        } catch (IOException ex) {
            logger.debug(ex.getMessage());
            throw new ResourceNotFoundExceptionHandler(String.format(APIMessage.FILE_NOT_STORE, fileName), ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        logger.info("Load file as resource");
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new ResourceNotFoundExceptionHandler(String.format(APIMessage.FILE_NOT_FOUND, fileName));
            }
        } catch (MalformedURLException e) {
            logger.debug(e.getMessage());
            throw new ResourceNotFoundExceptionHandler(String.format(APIMessage.FILE_NOT_FOUND, fileName), e);
        }
    }
}
