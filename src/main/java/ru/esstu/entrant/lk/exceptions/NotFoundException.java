package ru.esstu.entrant.lk.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
        log.info(message);
    }
}
