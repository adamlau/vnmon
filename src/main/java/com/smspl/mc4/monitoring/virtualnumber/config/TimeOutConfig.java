package com.smspl.mc4.monitoring.virtualnumber.config;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import org.joda.time.DateTime;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 12:43 PM
 */
public class TimeOutConfig {

    public static int DEFAULT_TIMEOUT = 120;

    private final HeartbeatEvent currentHeartbeat;
    private final int timeOutInSeconds;

    public TimeOutConfig(HeartbeatEvent currentHeartbeat, int timeOutInSeconds) {
        this.currentHeartbeat = currentHeartbeat;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    public boolean hasTimedOut(DateTime timeToCompare) {
        return currentHeartbeat.hasExpired(timeToCompare, timeOutInSeconds);
    }
}
