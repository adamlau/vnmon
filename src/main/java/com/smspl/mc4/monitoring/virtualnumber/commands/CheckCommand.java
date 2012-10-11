package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;

/**
 * User: adam
 * Date: 9/10/12
 */
public interface CheckCommand {
    void execute(HeartbeatEvent heartbeatEvent);
}
