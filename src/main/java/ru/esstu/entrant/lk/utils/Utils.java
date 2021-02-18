package ru.esstu.entrant.lk.utils;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {

    /**
     * ГУИД системного аккаунта.
     */
    public static final UUID SYS_ACCOUNT_GUID = UUID.fromString("00000000-0000-0000-0000-00000000001a");
    /**
     * ГУИД системного аккаунта.
     */
    public static final String OKTMO_DICTIONARY_CODE = "oktmo";

    public static String lang(String lang) {
        if (Utils.isNull(lang)) {
            return null;
        }

        return lang.contains("-") ? lang.split("-")[0] : lang;
    }

    public static List<String> split(String value) {
        if (Utils.nonNull(value)) {
            return value.contains(",") ? Arrays.asList(value.split(",")) : Collections.singletonList(value);
        }

        return Collections.emptyList();
    }

    public static <T> List<T> concat(List<T> l1, List<T> l2) {
        List<T> result = new ArrayList<>();

        if (nonNull(l1)) {
            result.addAll(map(l1, Function.identity()));
        }

        if (Objects.nonNull(l2)) {
            result.addAll(map(l2, Function.identity()));
        }

        return result;
    }

    public static <T> List<T> concat(List<T> list, T... array) {
        List<T> result = new ArrayList<>();

        if (nonNull(list)) {
            result.addAll(map(list, Function.identity()));
        }

        if (Objects.nonNull(array)) {
            result.addAll(map(Arrays.asList(array), Function.identity()));
        }

        return result;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return Utils.nonNull(list)
                ? list.stream().filter(Objects::nonNull).map(function).collect(Collectors.toList())
                : Collections.emptyList();
    }

    public static <T, R> List<R> map(Set<T> list, Function<T, R> function) {
        return Utils.nonNull(list)
                ? list.stream().filter(Objects::nonNull).map(function).collect(Collectors.toList())
                : Collections.emptyList();
    }

    public static long toLong(Date value) {
        return nonNull(value) ? value.getTime() : 0;
    }

    public static Long toNullableLong(Date value) {
        return nonNull(value) ? value.getTime() : null;
    }

    public static String toISO(Date value) {
        return value == null ? "" : new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(value);
    }

    public static String toISO(Long time) {
        return toISO(new Date(time));
    }

    public static Date fromISO(String value) {
        try {
            return Utils.nonNull(value) ? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(value) : null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date fromISOMinusDay(String value, Integer minusDay) {
        try {
            Date date = Utils.nonNull(value) ? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(value) : null;
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, -minusDay);
            return cal.getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static String formatDate(Date date) {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    public static String formatDateFromIso(String dateString, String outputDateFormat) {
        try {
            if (Utils.nonNull(dateString) && StringUtils.hasText(dateString)) {
                Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(dateString);
                return new SimpleDateFormat(outputDateFormat).format(date);
            } else {
                return "";
            }
        } catch (ParseException e) {
            return "";
        }
    }

    public static String formatDateFromIso(Long dateLong, String outputDateFormat) {
        if (Utils.nonNull(dateLong)) {
            return new SimpleDateFormat(outputDateFormat).format(new Date(dateLong));
        } else {
            return "";
        }
    }

    public static Date toDate(Long time) {
        return nonNull(time) ? new Date(time) : null;
    }

    public static int getYear(Date value) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(value);
        return calendar.get(Calendar.YEAR);
    }

    public static UUID guid(String guid) {
        return isNull(guid) ? UUID.randomUUID() : UUID.fromString(guid);
    }

    public static String getGUID(String guid) {
        return isNull(guid) ? getGUID() : guid;
    }

    public static String getGUID() {
        return UUID.randomUUID().toString();
    }

    public static UUID generateGUID() {
        return UUID.randomUUID();
    }

    public static String getAuthentication() {
        return ((KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
    }

    /**
     * @return логин
     */
    public static String getAuthenticationIfExist() {
        if (
                SecurityContextHolder.getContext() == null ||
                        SecurityContextHolder.getContext().getAuthentication() == null ||
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null) {
            return null;
        }
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof KeycloakPrincipal) {
            return ((KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName();
        }
        return null;
    }

    public static UUID getAuthenticationUuid() {
        return UUID.fromString(getAuthentication());
    }

    public static boolean nonNull(Object value) {
        return !isNull(value);
    }

    public static boolean isNull(Object value) {
        return Objects.isNull(value);
    }

    public static boolean isNull(Double value) {
        return value == null || Math.abs(value) < 0.00000001;
    }

    public static <K, V> boolean nonNull(Map<K, V> value) {
        return !isNull(value);
    }

    public static <K, V> boolean isNull(Map<K, V> value) {
        return value == null || value.isEmpty();
    }

    public static <T> boolean nonNull(Collection<T> value) {
        return !isNull(value);
    }

    public static <T> boolean isNull(Collection<T> value) {
        return value == null || value.isEmpty();
    }

    public static boolean nonNull(Long value) {
        return !isNull(value);
    }

    public static boolean isNull(Long value) {
        return value == null || value == 0;
    }

    public static boolean nonNull(String value) {
        return !isNull(value);
    }

    public static boolean isNull(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean nonNull(Integer value) {
        return !isNull(value);
    }

    public static boolean isNull(Integer value) {
        return value == null || value == 0;
    }

    public static int orEmpty(Integer value) {
        return nonNull(value) ? value : 0;
    }

    public static long orEmpty(Long value) {
        return nonNull(value) ? value : 0L;
    }

    public static float orEmpty(Float value) {
        return nonNull(value) ? value : 0f;
    }

    public static double orEmpty(Double value) {
        return nonNull(value) ? value : 0.0;
    }

    public static String orEmpty(String value) {
        return nonNull(value) ? value : "";
    }

    public static boolean orEmpty(Boolean value) {
        return value == null ? false : value;
    }

    /**
     * @param items исходный список
     * @param dtos  обновлённые значсения списока
     * @param eq    функция сравнения двух элементов
     * @param map   функция преобразования D в T
     * @param <T>   тип элементов исходного списка
     * @param <D>   тип элементов обновлённого списка
     * @return исходный список обновлённый значениями
     */
    public static <T, D> void updateList(List<T> items,
                                         List<D> dtos,
                                         BiFunction<T, D, Boolean> eq,
                                         Function<D, T> map
    ) {
        if (items == null) {
            items = new ArrayList<>();
        }
        if (dtos == null || dtos.isEmpty()) {
            items.clear();
            return;
        }
        Iterator<T> itr = items.iterator();
        while (itr.hasNext()) {
            T i = itr.next();
            boolean found = false;
            for (D dto : dtos) {
                if (eq.apply(i, dto)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                itr.remove();
            }
        }
        for (D dto : dtos) {
            boolean found = false;
            for (T item : items) {
                if (eq.apply(item, dto)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                items.add(map.apply(dto));
            }
        }
    }

    public static boolean isDiff(String s1, String s2) {
        if (Utils.isNull(s1) && Utils.nonNull(s2)) {
            return true;
        }
        if (Utils.isNull(s2) && Utils.nonNull(s1)) {
            return true;
        }
        if (Utils.isNull(s1) && Utils.isNull(s2)) {
            return false;
        }
        if (!s1.equals(s2)) {
            return true;
        }
        return false;
    }

}
