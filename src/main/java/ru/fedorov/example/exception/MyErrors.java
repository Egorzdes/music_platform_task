package ru.fedorov.example.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MyErrors {
    METHOD_DOES_NOT_EXIST(HttpStatus.NOT_ACCEPTABLE, "method doesnt implemented." ),
    EXECUTOR_WITHOUT_ALBUM(HttpStatus.FORBIDDEN, "executor without albums." ),
    EXECUTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "executor not found." ),
    ALBUM_NOT_FOUND(HttpStatus.NOT_FOUND, "album not found." );
    private final String message;
    private final HttpStatus httpStatus;


    MyErrors(HttpStatus httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
