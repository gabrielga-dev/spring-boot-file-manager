package br.com.gabsprojects.file_manager.data.io.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UuidWrapperResponse implements Serializable {

    private String uuid;
}
