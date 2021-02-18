package ru.esstu.entrant.lk.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Класс для работы с датами.
 */
public class DateUtils {
    /**
     * Формат даты.
     */
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    /**
     * ISO format.
     */
    public static final String ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZ";

    public static final String DATE_FORMAT_DD_MM_YYYY = "dd.MM.yyyy";

    /**
     * Форматер для дат в формате yyyy-MM-dd.
     */
    public static final ThreadLocal<SimpleDateFormat> YYYYMMDD
            = ThreadLocal.withInitial(() -> new SimpleDateFormat(DateUtils.YYYY_MM_DD_FORMAT));
    /**
     * Форматер для дат в формате dd.MM.YYYY.
     */
    public static final ThreadLocal<SimpleDateFormat> DDMMYYYY
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MM.yyyy"));
    /**
     * Форматер для дат в формате YYYY.
     */
    public static final ThreadLocal<SimpleDateFormat> YYYY
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy"));

    /**
     * Форматер для дат в формате ISO.
     */
    public static final ThreadLocal<SimpleDateFormat> ISO8601_DATE_FORMAT
            = ThreadLocal.withInitial(() -> new SimpleDateFormat(DateUtils.ISO8601_FORMAT));
    /**
     * Форматер для дат в формате ISO.
     */
    public static final ThreadLocal<DateTimeFormatter> ISO8601_FORMATTER
            = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern(DateUtils.ISO8601_FORMAT));

    /**
     * Форматировать timestamp в ISO формат.
     *
     * @param timestamp дата
     * @return строка
     */
    public static String formatISO(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        ZonedDateTime date = timestamp.toLocalDateTime().atZone(ZoneId.systemDefault());
        return date.format(ISO8601_FORMATTER.get());
    }

    /**
     * Форматировать date по формату.
     *
     * @param date
     * @param format
     * @return строка
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Форматировать date в ISO формат.
     *
     * @param date дата
     * @return строка
     */
    public static String formatISO(ZonedDateTime date) {
        if (date == null) {
            return "";
        }
        return date.format(ISO8601_FORMATTER.get());
    }

    public static Date atEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date atStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String toISOWithoutTimeZone(Date value) {
        return value == null ? "" : new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY).format(value);
    }

    public static String toYYYYMMDD(Date value) {
        return value == null ? "" : YYYYMMDD.get().format(value);
    }

    public static Date fromYYYYMMDD(String value) {
        if (Utils.nonNull(value)) {
            try {
                return YYYYMMDD.get().parse(value);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public static String toISOWithoutTimeZone(Long time) {
        return toISOWithoutTimeZone(new Date(time));
    }

    public static Date fromISOWithoutTimeZone(String value) {
        try {
            return Utils.nonNull(value) ? new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY).parse(value) : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
