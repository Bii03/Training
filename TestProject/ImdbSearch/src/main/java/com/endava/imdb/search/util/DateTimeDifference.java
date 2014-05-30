package com.endava.imdb.search.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by btesila on 5/28/2014.
 */

/**
 * This is a utility class for getting the time difference, expressed in minutes, between two Date objects
 */
public class DateTimeDifference {

    public static long getTimeDifferenceInMinutes(Date dateTime1, Date dateTime2){
        Calendar calendarObject1 = Calendar.getInstance();
        calendarObject1.setTime(dateTime1);

        Calendar calendarObject2 = Calendar.getInstance();
        calendarObject2.setTime(dateTime2);
        long diffMillis = calendarObject1.getTimeInMillis() - calendarObject2.getTimeInMillis();
        long diffMinutes = diffMillis / (60 * 1000);

        return diffMinutes;
    }
}
