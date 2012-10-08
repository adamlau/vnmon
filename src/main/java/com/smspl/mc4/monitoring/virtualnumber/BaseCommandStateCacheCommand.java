package com.smspl.mc4.monitoring.virtualnumber;

import org.jboss.solder.logging.Log;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseCommandStateCacheCommand {

    @Inject
    Logger log;

    public void execute(CheckCommandStateCache checkCommandStateCache)
    {
        log.infof("Executing command: %s" , this.getClass().getCanonicalName());
        doExecute(checkCommandStateCache);
    }

    protected void doExecute(CheckCommandStateCache checkCommandStateCache) {
    }
}
