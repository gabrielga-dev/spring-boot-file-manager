package br.com.gabsprojects.file_manager.business.useCase.file.impl;

import br.com.gabsprojects.file_manager.business.command.file.FindFileByTypeCommand;
import br.com.gabsprojects.file_manager.business.exception.command.FeatureNotImplementedYetException;
import br.com.gabsprojects.file_manager.business.useCase.file.FindImageFileUseCase;
import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindImageFileUseCaseImpl implements FindImageFileUseCase {

    private final List<FindFileByTypeCommand> findFileByTypeCommands;

    @Override
    public byte[] execute(String imageUuid) {
        var imageCommand = findFileByTypeCommands.stream()
                .filter(command -> command.getOriginType().equals(FileOriginType.IMAGE))
                .findFirst()
                .orElseThrow(FeatureNotImplementedYetException::new);
        return imageCommand.findByUuidOrElseThrow(imageUuid);
    }
}
