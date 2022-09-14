package com.github.juliherms.ms.pet.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicateBreedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static Logger logger = LoggerFactory.getLogger(DuplicateBreedException.class);


    public DuplicateBreedException(String description) {
        super("Já existe uma raça cadastrada com a descrição = " + description);
    }
}
