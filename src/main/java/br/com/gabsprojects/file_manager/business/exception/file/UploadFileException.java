package br.com.gabsprojects.file_manager.business.exception.file;

import br.com.gabsprojects.file_manager.business.exception.BaseException;

public class UploadFileException extends BaseException {

    public UploadFileException() {
        super(
                "Erro ao realizar upload!",
                "Ops! houve algum erro ao realizar o upload do seu arquivo! Tente novamente mais tarde!"
        );
    }
}
