package ru.esstu.entrant.lk.exceptions;

import java.net.MalformedURLException;

public class PermissionException extends RuntimeException {

    public PermissionException(MalformedURLException e) {
        super(e.getMessage(), e);
    }

    public PermissionException(String message) {
        super(message);
    }
}
