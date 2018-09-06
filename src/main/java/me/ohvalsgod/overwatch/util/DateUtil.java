package me.ohvalsgod.overwatch.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

    public static String formatDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.setTime(date);

        return calendar.getTime().toString();
    }

    public static String formatDateFormal(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss z 'on' dd/MM/yyyy");

        return format.format(date);
    }

}
