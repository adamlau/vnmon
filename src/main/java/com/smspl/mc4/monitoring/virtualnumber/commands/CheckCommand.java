package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 9/10/12
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CheckCommand {
    void execute(HeartbeatEvent heartbeatEvent);
}
