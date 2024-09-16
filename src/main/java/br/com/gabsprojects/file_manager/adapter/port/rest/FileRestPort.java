package br.com.gabsprojects.file_manager.adapter.port.rest;

import br.com.gabsprojects.file_manager.adapter.port.FilePort;
import br.com.gabsprojects.file_manager.business.useCase.file.UploadFileUseCase;
import br.com.gabsprojects.file_manager.data.io.out.UuidWrapperResponse;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/file")
public class FileRestPort implements FilePort {

    private final UploadFileUseCase uploadFileUseCase;

    @Override
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public UuidWrapperResponse uploadFile(FileOriginType origin, String originUuid, MultipartFile file) {
        return uploadFileUseCase.uploadFile(origin, originUuid, file);
    }
}
