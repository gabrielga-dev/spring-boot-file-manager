package br.com.gabsprojects.file_manager.business.useCase.file.impl;

import br.com.gabsprojects.file_manager.business.command.file.SaveFileCommand;
import br.com.gabsprojects.file_manager.business.useCase.file.UploadFileUseCase;
import br.com.gabsprojects.file_manager.data.io.out.UuidWrapperResponse;
import br.com.gabsprojects.file_manager.data.model.FileModel;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
@RequiredArgsConstructor
public class UploadFileUseCaseImpl implements UploadFileUseCase {

    private final SaveFileCommand saveFileCommand;

    @Override
    public UuidWrapperResponse uploadFile(FileOriginType origin, String originUuid, MultipartFile file) {
        log.info("Trying to upload file. Origin: {}, Origin UUID: {}", origin, originUuid);

        var notSavedFile = new FileModel(origin, originUuid, file);
        var savedFile = saveFileCommand.save(notSavedFile, file);

        var uuidWrapper = new UuidWrapperResponse(savedFile.getUuid());

        log.info(
                "File uploaded! File's UUID: {}, Origin: {}, Origin UUID: {}",
                uuidWrapper.getUuid(),
                origin,
                originUuid
        );
        return uuidWrapper;
    }
}
