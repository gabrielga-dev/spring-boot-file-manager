package br.com.gabsprojects.file_manager.adapter.repository.mysql;

import br.com.gabsprojects.file_manager.adapter.repository.FileRepository;
import br.com.gabsprojects.file_manager.data.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMySQLRepository extends FileRepository, JpaRepository<FileModel, String> {
}
