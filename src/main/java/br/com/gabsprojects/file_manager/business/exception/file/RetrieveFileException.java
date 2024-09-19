package br.com.gabsprojects.file_manager.business.exception.file;

import br.com.gabsprojects.file_manager.business.exception.BaseException;

public class RetrieveFileException extends BaseException {

    public RetrieveFileException() {
        super(
                "Erro ao buscar arquivo!",
                "Ocorreu algo de inesperado ao buscar o arquivo desejado, tente novamente mais tarde!"
        );
    }
}
