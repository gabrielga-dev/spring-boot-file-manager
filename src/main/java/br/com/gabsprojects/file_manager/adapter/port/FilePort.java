package br.com.gabsprojects.file_manager.adapter.port;

import br.com.gabsprojects.file_manager.data.io.out.UuidWrapperResponse;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FilePort {

    UuidWrapperResponse uploadFile(
            @RequestParam FileOriginType origin,
            @RequestParam String originUuid,
            @RequestParam("file") MultipartFile file
    );
}
