package org.marinfo.mapleinfobe.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "org.marinfo.mapleinfobe", annotations = RestController.class)
public class ControllerAdvisor {

    @ExceptionHandler(OpenApiException.class)
    public ResponseEntity<OpenApiErrorResult> handleOpenApiException(OpenApiException e) {
        log.error("OpenApiException : {}", e.getLocalizedMessage());
        return ResponseEntity.badRequest().body(new OpenApiErrorResult(e.getName(), e.getMessage()));
    }
}
