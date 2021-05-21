package ru.esstu.entrant.lk.exceptions;

/**
 * Исключение для случая неверного состояния объекта.
 */
public class InvalidObjectException extends RuntimeException {

    /**
     * @param message сообщение
     */
    public InvalidObjectException(final String message) {
        super(message);
    }

    /**
     * @param message сообщение
     * @param cause   причина исключения
     */
    public InvalidObjectException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
