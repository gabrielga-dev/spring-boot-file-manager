package br.com.gabsprojects.file_manager.business.command.file.impl;

import br.com.gabsprojects.file_manager.adapter.fileStorage.FileStorage;
import br.com.gabsprojects.file_manager.adapter.repository.FileRepository;
import br.com.gabsprojects.file_manager.business.command.file.SaveFileCommand;
import br.com.gabsprojects.file_manager.data.model.FileModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class SaveFileCommandImpl implements SaveFileCommand {

    private final FileRepository fileRepository;
    private final FileStorage fileStorage;

    @Override
    @Transactional
    public FileModel save(FileModel fileModel, MultipartFile file) {
        var savedFile = fileRepository.save(fileModel);
        fileStorage.uploadFile(fileModel.getFilePath(), file);
        return savedFile;
    }
}
