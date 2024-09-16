package br.com.gabsprojects.file_manager.adapter.port.rest;

import br.com.gabsprojects.file_manager.adapter.port.FilePort;
import br.com.gabsprojects.file_manager.business.useCase.file.UploadFileUseCase;
import br.com.gabsprojects.file_manager.data.io.out.UuidWrapperResponse;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/file")
public class FileRestPort implements FilePort {

    private final UploadFileUseCase uploadFileUseCase;

    @Override
    @PostMapping
    public ResponseEntity<UuidWrapperResponse> uploadFile(
            @RequestParam FileOriginType origin,
            @RequestParam String originUuid,
            @RequestParam("file") MultipartFile file
    ) {
        var uuidWrapper = uploadFileUseCase.uploadFile(origin, originUuid, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(uuidWrapper);
    }
}
