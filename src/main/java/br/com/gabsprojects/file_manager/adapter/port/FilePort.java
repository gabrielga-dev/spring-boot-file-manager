package br.com.gabsprojects.file_manager.adapter.port;

import br.com.gabsprojects.file_manager.data.io.out.UuidWrapperResponse;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FilePort {

    ResponseEntity<UuidWrapperResponse> uploadFile(
            FileOriginType origin, @Size(max = 36, min = 36) String originUuid, MultipartFile file
    );

    ResponseEntity<byte[]> getImage(String uuid);
}
