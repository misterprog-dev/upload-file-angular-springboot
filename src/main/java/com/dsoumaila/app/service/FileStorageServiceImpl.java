package com.dsoumaila.app.service;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.util.Objects.requireNonNull;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final Path root = Paths.get("src/main/resources/images");

    @Override
    public void init() {
        try {
            // Check if folder don't exists.
            if (!Files.exists(root)){
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory.");
        }
    }

    @Override
    public void storeLocal(MultipartFile file, String fileName) {
        try {
            String imageDir = root + "/";
            Path uploadPath = Paths.get(imageDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(requireNonNull(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), filePath, REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Error to save a file : " + e.getMessage());
        }
    }
}
