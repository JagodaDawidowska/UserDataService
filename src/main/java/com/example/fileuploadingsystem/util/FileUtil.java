package com.example.fileuploadingsystem.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    private static final String JSON_EXTENSION = "json";

    private FileUtil () {}

    public static boolean checkIfFormatIsJson(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return JSON_EXTENSION.equals(extension);
    }
}
