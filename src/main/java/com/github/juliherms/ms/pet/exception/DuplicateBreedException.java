package com.github.juliherms.ms.pet.exception;

public class DuplicateBreedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicateBreedException(String description) {
        super("Já existe uma raça cadastrada com a descrição = " + description);
    }
}
