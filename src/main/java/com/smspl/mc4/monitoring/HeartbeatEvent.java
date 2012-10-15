package com.smspl.mc4.monitoring;

import org.joda.time.DateTime;

/**
 * User: adamlau
 * Date: 3/10/12
 */
public class HeartbeatEvent {
    private DateTime eventTime;

    public HeartbeatEvent() {
        this.eventTime = new DateTime();
    }

    public boolean isDue(DateTime dueTime)
    {
        if( dueTime == null ) return true;

        return eventTime.isAfter(dueTime);
    }

    public DateTime getDueNext(int periodInSeconds)
    {
        return eventTime.plusSeconds(periodInSeconds);
    }

    public boolean hasExpired(DateTime startTime, int timeoutInSeconds)
    {
        return eventTime.isAfter(startTime.plusSeconds(timeoutInSeconds));
    }

    public DateTime getTime()
    {
        return eventTime;
    }
}