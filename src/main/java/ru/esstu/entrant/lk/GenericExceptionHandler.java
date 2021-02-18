package ru.esstu.entrant.lk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Обработчик ошибок, которые не были обработаны ранее.
 */
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class GenericExceptionHandler {

    /**
     * Обработчик исключений.
     *
     * @param e исключение
     * @return возвращает структуру, представляющую 500 ошибку с соответствующим сообщением.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericExceptions(final Exception e) {
        if (log.isDebugEnabled()) {
            log.error(e.getMessage(), e);
        }
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
