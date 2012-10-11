package com.smspl.mc4.monitoring;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * User: adamlau
 * Date: 3/10/12
 */
public class HeartbeatEvent {
    private Calendar calendar;
    public HeartbeatEvent() {
        this.calendar = new GregorianCalendar();
    }
    /**
     * "at x hour and y minutes"
     * Use minute == 0 to test against a specific full hour.
     * @param hour 0-23
     * @param minute 0-59
     * @return true if match
     */
    public boolean isTime(int hour, int minute) {
        return calendar.get(Calendar.HOUR_OF_DAY) == hour && calendar.get(Calendar.MINUTE) == minute;
    }
    /**
     * "every n minutes"
     * @param minutes minute interval 0-59
     * @return true if match
     */
    public boolean isMinuteInterval(int minutes) {
        return calendar.get(Calendar.MINUTE) % minutes == 0;
    }
    /**
     * "every n hours"
     * @param hour 0-23
     * @return true if match
     */
    public boolean isHourInterval(int hour) {
        return calendar.get(Calendar.HOUR_OF_DAY) % hour == 0 && isFullHour();
    }
    public boolean isFullHour() {
        return calendar.get(Calendar.MINUTE) == 0;
    }
    public boolean isHalfHour() {
        return isMinuteInterval(30);
    }
    public boolean isQuarterHour() {
        return isMinuteInterval(15);
    }

    public boolean isDue(GregorianCalendar due)
    {
        if( due == null ) return true;

        return calendar.after(due);
    }

    public GregorianCalendar getDueNext(int periodInSeconds)
    {
        GregorianCalendar calendarCopy = (GregorianCalendar)calendar.clone();
        calendarCopy.add(Calendar.SECOND, periodInSeconds);
        return calendarCopy;
    }
}