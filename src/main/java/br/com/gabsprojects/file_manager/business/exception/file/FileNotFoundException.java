package br.com.gabsprojects.file_manager.business.exception.file;

import br.com.gabsprojects.file_manager.business.exception.BaseException;

public class FileNotFoundException extends BaseException {

    public FileNotFoundException() {
        super(
                "Não foi possível encontrar o arquivo!",
                "Não foi encontrado nenhum arquivo com as credenciais informadas!"
        );
    }
}
