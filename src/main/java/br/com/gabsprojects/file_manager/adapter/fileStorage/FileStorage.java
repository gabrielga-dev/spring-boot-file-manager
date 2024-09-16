package br.com.gabsprojects.file_manager.adapter.fileStorage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {

    byte[] getFile(String remoteFilePath);

    void uploadFile(String remoteFilePath, MultipartFile file);
}
