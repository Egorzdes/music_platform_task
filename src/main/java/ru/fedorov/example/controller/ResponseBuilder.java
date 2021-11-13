package ru.fedorov.example.controller;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T>ResponseEntity<T> build(T data) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Constants.Header.REQUEST_ID, ThreadContext.get(Constants.Header.REQUEST_ID));
        return ResponseEntity.ok().headers(httpHeaders).body(data);
    }

    public static <T>ResponseEntity<T> buildWithCode(T data, int code) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Constants.Header.REQUEST_ID, ThreadContext.get(Constants.Header.REQUEST_ID));
        return ResponseEntity.status(code).headers(httpHeaders).body(data);
    }
}
