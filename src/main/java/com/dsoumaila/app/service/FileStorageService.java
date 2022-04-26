package com.dsoumaila.app.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

public interface FileStorageService {

    void init();

    /**
     * Store image in local
     *
     * @param file the file to store
     * @param fileName the name of image in local storage.
     */
    void storeLocal(MultipartFile file, String fileName);
}
