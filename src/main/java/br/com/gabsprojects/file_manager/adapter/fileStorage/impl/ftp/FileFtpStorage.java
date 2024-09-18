package br.com.gabsprojects.file_manager.adapter.fileStorage.impl.ftp;

import br.com.gabsprojects.file_manager.adapter.fileStorage.FileStorage;
import br.com.gabsprojects.file_manager.business.exception.file.UploadFileException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "spring.application.file.storage.technology", havingValue = "ftp")
public class FileFtpStorage implements FileStorage {

    @Value("${spring.application.file.storage.ftp.server}")
    private String server;
    @Value("${spring.application.file.storage.ftp.port}")
    private int port;
    @Value("${spring.application.file.storage.ftp.username}")
    private String username;
    @Value("${spring.application.file.storage.ftp.password}")
    private String password;

    private FTPClient getClient() throws IOException {
        var ftpClient = new FTPClient();

        ftpClient.connect(server, port);
        ftpClient.login(username, password);
        ftpClient.enterLocalPassiveMode();

        return ftpClient;
    }

    @Override
    public byte[] getFile(String remoteFilePath) {
        return new byte[0];
    }

    @Override
    public void uploadFile(String remoteFilePath, MultipartFile file) {
        try {
            final FTPClient ftpClient = getClient();
            var inputStream = file.getInputStream();
            try {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                var returned = ftpClient.storeFile(remoteFilePath, inputStream);

                if (!returned) {
                    throw new UploadFileException();
                }
            } finally {
                ftpClient.logout();
                ftpClient.disconnect();
            }
            inputStream.close();
        } catch (IOException ex) {
            log.error(
                    "Error at logging into FTP server! Username: {} | Password: {} | Server: {} | Port: {} | Error: {}",
                    username, password, server, port, ex.getMessage()
            );
            throw new UploadFileException();
        }
    }
}
