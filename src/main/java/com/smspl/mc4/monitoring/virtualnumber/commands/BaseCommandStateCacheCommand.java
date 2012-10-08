package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckCommandStateCache;
import org.jboss.solder.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseCommandStateCacheCommand {

    @Inject
    CheckCommandStateCache checkCommandStateCache;

    @Inject
    Logger log;

    public void execute() {
        log.infof("Executing command: %s", this.getClass().getCanonicalName());
        doExecute(checkCommandStateCache);
    }

    protected void doExecute(CheckCommandStateCache checkCommandStateCache) {
    }

    protected void doTimedExecute(CheckCommandStateCache checkCommandStateCache, HeartbeatEvent heartbeatEvent) {
    }

    public void runChecks(@Observes HeartbeatEvent heartbeatEvent) {
        doTimedExecute(checkCommandStateCache, heartbeatEvent);
    }


}
