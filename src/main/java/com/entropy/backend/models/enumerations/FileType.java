package com.entropy.backend.models.enumerations;

import com.entropy.backend.common.constants.APIMessage;
import com.entropy.backend.exceptions.ResourceNotFoundExceptionHandler;
import lombok.Getter;

import java.util.Arrays;

public enum FileType {
    JPG(0, "jpg"),
    JPEG(1, "jpeg"),
    PNG(2, "png"),
    GIFT(3, "gif"),
    TXT(3, "txt"),
    CSV(4, "csv"),
    DOCX(5, "docx"),
    EXCEL(6, "xlsx"),
    PDF(7, "pdf");

    @Getter
    private final int value;
    @Getter
    private final String name;

    FileType(int value, final String name) {
        this.value = value;
        this.name = name;
    }


    public static FileType findByValue(int value) {
        return Arrays.stream(FileType.values())
                .filter(fileType -> fileType.getValue() == value)
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.FILE_TYPE_INVALID));
    }

    public static FileType findByName(String name) {
        return Arrays.stream(FileType.values()).filter(fileType -> fileType.getName().equals(name))
                .findFirst().orElseThrow(() -> new ResourceNotFoundExceptionHandler(APIMessage.FILE_TYPE_INVALID));
    }

}
