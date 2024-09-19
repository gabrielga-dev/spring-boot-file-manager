package br.com.gabsprojects.file_manager.business.useCase.file;

public interface FindImageFileUseCase {

    byte[] execute(String imageUuid);
}
