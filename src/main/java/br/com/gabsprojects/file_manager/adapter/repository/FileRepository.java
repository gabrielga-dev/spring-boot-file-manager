package br.com.gabsprojects.file_manager.adapter.repository;

import br.com.gabsprojects.file_manager.data.model.FileModel;

import java.util.Optional;

public interface FileRepository {

    FileModel save(FileModel fileModel);

    Optional<FileModel> finByUuid(String id);
}
