package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheckSubmitMessagesCommand extends BaseCommandStateCacheCommand {

    @Inject
    Logger log;

    @Override
    protected void doTimedExecute(CheckStateStore checkCommandStateCache, HeartbeatEvent heartbeatEvent) {
        log.info("Executing in a timed fashion");
    }
}
