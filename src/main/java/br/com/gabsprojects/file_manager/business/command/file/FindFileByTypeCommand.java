package br.com.gabsprojects.file_manager.business.command.file;

import br.com.gabsprojects.file_manager.adapter.fileStorage.FileStorage;
import br.com.gabsprojects.file_manager.adapter.repository.FileRepository;
import br.com.gabsprojects.file_manager.business.exception.file.FileNotFoundException;
import br.com.gabsprojects.file_manager.data.model.FileModel;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class FindFileByTypeCommand {

    protected final FileRepository fileRepository;
    protected final FileStorage fileStorage;

    public abstract FileOriginType getOriginType();

    public FileModel findRecordByUuidOrElseThrow(String uuid) {
        var foundFile = fileRepository.finByUuid(uuid).orElseThrow(FileNotFoundException::new);
        if (!getOriginType().equals(foundFile.getOriginType())) {
            throw new FileNotFoundException();
        }
        return foundFile;
    }

    public byte[] findByUuidOrElseThrow(String uuid) {
        var foundFile = this.findRecordByUuidOrElseThrow(uuid);
        return fileStorage.getFile(foundFile.getFilePath());
    }
}
