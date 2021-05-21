package ru.esstu.entrant.lk.exceptions;

/**
 * Исключение для случая отсутствия прав у пользователя для совершения действия.
 */
public class PermissionDeniedException extends RuntimeException {

    /**
     * @param message сообщение
     */
    public PermissionDeniedException(final String message) {
        super(message);
    }

    /**
     * @param message сообщение
     * @param cause   причина исключения
     */
    public PermissionDeniedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
