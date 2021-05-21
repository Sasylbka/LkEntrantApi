package ru.esstu.entrant.lk.exceptions;

/**
 * Исключение для случая попытки добавления дублирущего объекта в БД, когда это не допускается.
 */
public class DuplicateObjectException extends RuntimeException {

    /**
     * @param message сообщение
     */
    public DuplicateObjectException(final String message) {
        super(message);
    }

    /**
     * @param message сообщение
     * @param cause   причина исключения
     */
    public DuplicateObjectException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
