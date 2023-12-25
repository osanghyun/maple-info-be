package org.marinfo.mapleinfobe.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "org.marinfo.mapleinfobe", annotations = RestController.class)
public class ControllerAdvisor {

    @ExceptionHandler(NexonOpenApiException.class)
    public ResponseEntity<NexonOpenApiErrorResult> handleOpenApiException(NexonOpenApiException e) {
        log.error("OpenApiException : {}", e.getLocalizedMessage());
        return ResponseEntity.badRequest().body(new NexonOpenApiErrorResult(e.getName(), e.getMessage()));
    }
}
