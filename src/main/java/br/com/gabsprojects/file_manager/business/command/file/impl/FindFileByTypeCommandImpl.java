package br.com.gabsprojects.file_manager.business.command.file.impl;

import br.com.gabsprojects.file_manager.adapter.fileStorage.FileStorage;
import br.com.gabsprojects.file_manager.adapter.repository.FileRepository;
import br.com.gabsprojects.file_manager.business.command.file.FindFileByTypeCommand;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import org.springframework.stereotype.Component;

@Component
public class FindFileByTypeCommandImpl extends FindFileByTypeCommand {

    public FindFileByTypeCommandImpl(FileRepository fileRepository, FileStorage fileStorage) {
        super(fileRepository, fileStorage);
    }

    @Override
    public FileOriginType getOriginType() {
        return FileOriginType.IMAGE;
    }
}
