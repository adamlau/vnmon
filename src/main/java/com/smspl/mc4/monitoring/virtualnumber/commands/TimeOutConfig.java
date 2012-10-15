package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import org.joda.time.DateTime;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 12:43 PM
 */
public class TimeOutConfig {
    private HeartbeatEvent currentHeartbeat;
    private int timeOutInSeconds;

    public TimeOutConfig(HeartbeatEvent currentHeartbeat, int timeOutInSeconds) {
        this.currentHeartbeat = currentHeartbeat;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    public boolean hasTimedOut(DateTime timeToCompare) {
        return currentHeartbeat.hasExpired(timeToCompare, timeOutInSeconds);
    }
}
