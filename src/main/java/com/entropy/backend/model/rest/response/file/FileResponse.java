package com.entropy.backend.model.rest.response.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FileResponse {
    @JsonProperty("file_name")
    private String fileName;
    @JsonProperty("file_download_uri")
    private String fileDownloadUri;
    @JsonProperty("file_type")
    private String fileType;
    private long size;
}
