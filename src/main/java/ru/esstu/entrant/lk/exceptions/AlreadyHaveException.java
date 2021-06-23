package ru.esstu.entrant.lk.exceptions;

public class AlreadyHaveException extends RuntimeException{
    public AlreadyHaveException(final String message){ super(message);}
    public AlreadyHaveException(final String message, final Throwable cause){
        super(message, cause);
    }
}
