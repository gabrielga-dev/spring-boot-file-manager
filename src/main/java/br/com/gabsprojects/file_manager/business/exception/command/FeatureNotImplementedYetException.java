package br.com.gabsprojects.file_manager.business.exception.command;

import br.com.gabsprojects.file_manager.business.exception.BaseException;

public class FeatureNotImplementedYetException extends BaseException {

    public FeatureNotImplementedYetException() {
        super(
                "Não foi possível acessa esta funcionalidade!",
                "Esta funcionalidade não pode ser acessada pois ela ainda não foi implementada."
        );
    }
}
