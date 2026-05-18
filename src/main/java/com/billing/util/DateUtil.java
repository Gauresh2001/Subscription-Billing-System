package com.billing.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private DateUtil() {
    }

    public static String formatLocalDate(
            LocalDate date) {

        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return date.format(formatter);
    }

    public static String formatLocalDateTime(LocalDateTime dateTime) {

        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return dateTime.format(formatter);
    }
}
