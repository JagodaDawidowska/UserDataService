package com.example.fileuploadingsystem.util;

import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void checkIfFormatIsJson_should_succeed() {
        MultipartFile file = getMockFile("filename.json");
        assertTrue(FileUtil.checkIfFormatIsJson(file));
    }

    @Test
    void checkIfFormatIsJson_should_fail () {
        MultipartFile file = getMockFile("filename.txt");
        assertFalse(FileUtil.checkIfFormatIsJson(file));
    }

    private MultipartFile getMockFile (String filename) {
        return new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return filename;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {

            }
        };
    }
}