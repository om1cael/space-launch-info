package com.om1cael.sli;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LaunchInfoUtils {
    public String getFormattedLaunchTime(String date) {
        DateTimeFormatter isoDateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(date, isoDateTimeFormatter);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm");
        return dateTime.format(dateTimeFormatter);
    }
}
