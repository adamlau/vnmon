package com.smspl.mc4.monitoring.util;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 12:07 PM
 */
public class DateFormatter {

    private static PeriodFormatter formatter;

    static {
        formatter = new PeriodFormatterBuilder().appendDays().appendSuffix(" day ", " days ")
                .appendHours().appendSuffix(" hour ", " hours ")
                .appendMinutes().appendSuffix(" minute ", " minutes ")
                .appendSeconds().appendSuffix(" second ", " seconds ")
                .toFormatter();

    }

    public static String printTimeRemaining(DateTime startTime, DateTime endTime)
    {
        return formatter.print(new Period(startTime, endTime, PeriodType.dayTime()) );
    }
}
