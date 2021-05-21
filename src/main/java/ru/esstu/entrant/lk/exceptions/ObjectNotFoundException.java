package ru.esstu.entrant.lk.exceptions;

/**
 * Исключение для случая отсутствия объекта в БД.
 */
public class ObjectNotFoundException extends RuntimeException {

    /**
     * @param message сообщение
     */
    public ObjectNotFoundException(final String message) {
        super(message);
    }

    /**
     * @param message сообщение
     * @param cause   причина исключения
     */
    public ObjectNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
