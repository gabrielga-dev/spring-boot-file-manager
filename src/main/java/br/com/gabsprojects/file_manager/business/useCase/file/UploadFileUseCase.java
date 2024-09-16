package br.com.gabsprojects.file_manager.business.useCase.file;

import br.com.gabsprojects.file_manager.data.io.out.UuidWrapperResponse;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {

    UuidWrapperResponse uploadFile(FileOriginType origin, String originUuid, MultipartFile file);
}
