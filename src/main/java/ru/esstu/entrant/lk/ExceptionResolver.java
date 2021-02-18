package ru.esstu.entrant.lk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.esstu.entrant.lk.exceptions.ApiError;

@ControllerAdvice
@Slf4j
public class ExceptionResolver extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> resolve(IllegalArgumentException e) {
        if (log.isDebugEnabled()) {
            log.error(e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), null));
    }
}
