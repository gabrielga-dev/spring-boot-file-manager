package br.com.gabsprojects.file_manager.adapter.repository.mysql;

import br.com.gabsprojects.file_manager.adapter.repository.FileRepository;
import br.com.gabsprojects.file_manager.data.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileMySQLRepository extends FileRepository, JpaRepository<FileModel, String> {

    default Optional<FileModel> finByUuid(String id){
        return this.findById(id);
    }
}
