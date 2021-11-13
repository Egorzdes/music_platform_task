package ru.fedorov.example.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class Exception extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;


    public Exception(MyErrors myErrors) {
        this.httpStatus = myErrors.getHttpStatus();
        this.message = myErrors.getMessage();
    }

}
