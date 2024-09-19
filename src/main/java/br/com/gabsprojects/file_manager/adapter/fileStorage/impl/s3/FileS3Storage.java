package br.com.gabsprojects.file_manager.adapter.fileStorage.impl.s3;

import br.com.gabsprojects.file_manager.adapter.fileStorage.FileStorage;
import br.com.gabsprojects.file_manager.business.exception.file.UploadFileException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "spring.application.file.storage.technology", havingValue = "s3")
public class FileS3Storage implements FileStorage {

    private final AmazonS3 amazonS3Client;

    @Value("${spring.application.file.storage.s3.bucket-name}")
    private String bucketName;

    @Override
    public byte[] getFile(String remoteFilePath) {
        try {
            var s3object = amazonS3Client.getObject(bucketName, remoteFilePath);
            return s3object.getObjectContent().readAllBytes();
        } catch (IOException e) {
            log.error(
                    "Error when retrieving the file {}. {}; {}",
                    remoteFilePath, e.getMessage(), e.getLocalizedMessage()
            );
            throw new UploadFileException();
        }
    }

    @Override
    public void uploadFile(String remoteFilePath, MultipartFile file) {
        try {
            var metaData = new ObjectMetadata();
            metaData.setContentType(file.getContentType());
            metaData.setContentLength(file.getSize());

            amazonS3Client.putObject(bucketName, remoteFilePath, file.getInputStream(), metaData);
        } catch (Exception e) {
            log.error(
                    "Error when uploading the file {}. {}; {}",
                    remoteFilePath, e.getMessage(), e.getLocalizedMessage()
            );
            throw new UploadFileException();
        }
    }
}
