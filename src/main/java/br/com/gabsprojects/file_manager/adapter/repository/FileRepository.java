package br.com.gabsprojects.file_manager.adapter.repository;

import br.com.gabsprojects.file_manager.data.model.FileModel;

public interface FileRepository {

    FileModel save(FileModel fileModel);
}
