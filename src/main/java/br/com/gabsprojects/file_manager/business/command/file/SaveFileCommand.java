package br.com.gabsprojects.file_manager.business.command.file;

import br.com.gabsprojects.file_manager.data.model.FileModel;
import org.springframework.web.multipart.MultipartFile;

public interface SaveFileCommand {

    FileModel save(FileModel fileModel, MultipartFile file);
}
