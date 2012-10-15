package com.smspl.mc4.monitoring.virtualnumber.config;

import org.joda.time.DateTime;
import org.joda.time.Interval;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 2:06 PM
 */
public class PeriodCalculator {

    private int highFrequencyPeriodInSeconds = 15 * 60;
    private int defaultPeriodInSeconds = 60 * 60;

    private int startHour = 8;
    private int startMinute = 0;
    private int endHour = 17;
    private int endMinute = 59;

    private Interval highFrequencyInterval;

    public PeriodCalculator() {
        highFrequencyInterval = new Interval(
                new DateTime().withHourOfDay(startHour).withMinuteOfHour(startMinute),
                new DateTime().withHourOfDay(endHour).withMinuteOfHour(endMinute));
    }

    public int getPeriodInSeconds(DateTime heartbeatTime)
    {
        if( highFrequencyInterval.contains(heartbeatTime) )
            return highFrequencyPeriodInSeconds;
        else
            return defaultPeriodInSeconds;
    }
}
