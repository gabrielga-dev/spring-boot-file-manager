package br.com.gabsprojects.file_manager.business.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseException extends RuntimeException {

    private final String title;
    private final String message;
}
