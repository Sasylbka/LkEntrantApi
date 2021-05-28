package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import ru.esstu.entrant.lk.domain.dto.ErrorResponse;
import ru.esstu.entrant.lk.exceptions.DuplicateObjectException;
import ru.esstu.entrant.lk.exceptions.InvalidObjectException;
import ru.esstu.entrant.lk.exceptions.ObjectNotFoundException;
import ru.esstu.entrant.lk.exceptions.PermissionDeniedException;

import javax.validation.ValidationException;

/**
 * Общий обработчик ошибок.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlingController{

    /**
     * Обработка исключения.
     *
     * @param e обрабатываемое исключение
     * @return response
     */
    @ExceptionHandler({HttpMessageConversionException.class, MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class, HttpRequestMethodNotSupportedException.class,
            MissingServletRequestPartException.class, ValidationException.class,
            ObjectNotFoundException.class, InvalidObjectException.class})
    public ResponseEntity<ErrorResponse> handleObjectNotFoundException(
            final Exception e) {

        if (log.isErrorEnabled()) {
            log.error("ObjectNotFoundException handled in ExceptionHandlingController: " + e.getMessage(), e);
        }

        return new ResponseEntity<>(new ErrorResponse(e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    /**
     * Обработка исключения.
     *
     * @param e обрабатываемое исключение
     * @return response
     */
    @ExceptionHandler(DuplicateObjectException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateObjectException(
            final DuplicateObjectException e) {

        if (log.isErrorEnabled()) {
            log.error("DuplicateObjectException handled in ExceptionHandlingController: " + e.getMessage(), e);
        }

        return new ResponseEntity<>(new ErrorResponse(e.getMessage()),
                HttpStatus.CONFLICT);
    }

    /**
     * Обработка исключения.
     *
     * @param e обрабатываемое исключение
     * @return response
     */
    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<ErrorResponse> handlePermissionDeniedException(
            final PermissionDeniedException e) {

        if (log.isErrorEnabled()) {
            log.error("PermissionDeniedException handled in ExceptionHandlingController: " + e.getMessage(), e);
        }

        return new ResponseEntity<>(new ErrorResponse(e.getMessage()),
                HttpStatus.FORBIDDEN);
    }

    /**
     * Обработка исключения.
     *
     * @param e обрабатываемое исключение
     * @return response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            final Exception e) {

        if (log.isErrorEnabled()) {
            log.error("Exception handled in ExceptionHandlingController: " + e.getMessage(), e);
        }

        return new ResponseEntity<>(new ErrorResponse(e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
