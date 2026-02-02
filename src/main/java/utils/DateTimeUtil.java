package utils;

 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    public static String getCurrentDateTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    }

    public static String getFormattedDate(String pattern) {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(pattern));
    }
}
