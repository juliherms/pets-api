package com.github.juliherms.ms.pet.handler;

import com.github.juliherms.ms.pet.dto.ErrorDTO;
import com.github.juliherms.ms.pet.exception.DuplicateBreedException;
import com.github.juliherms.ms.pet.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PetHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateBreedException.class)
    public ErrorDTO duplicateExceptionHandler(DuplicateBreedException duplicateBreedException) {
        return new ErrorDTO(duplicateBreedException);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDTO notFoundExceptionHandler(NotFoundException notFoundException) {
        return new ErrorDTO(notFoundException);
    }


}
