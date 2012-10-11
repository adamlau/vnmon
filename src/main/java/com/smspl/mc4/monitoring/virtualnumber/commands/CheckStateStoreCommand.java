package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;

/**
 * User: adam
 * Date: 9/10/12
 */
public abstract class CheckStateStoreCommand implements CheckCommand {

    private HeartbeatEvent heartbeatEvent;

    @Inject
    CheckStateStore checkStateStore;

    @Inject
    Logger log;

    @Override
    public void execute(HeartbeatEvent heartbeatEvent) {
        this.heartbeatEvent = heartbeatEvent;
        try {
            doPreExecute();
            if (canExecute()) {
                doExecute();
                doPostExecute();
            }
        } catch (Exception e) {
            log.error(e);
        }

    }

    protected void doPreExecute() {
    }

    protected boolean canExecute() {
        return true;
    }

    protected abstract void doExecute();

    protected void doPostExecute() {
    }

    protected HeartbeatEvent getHeartbeatEvent() {
        return this.heartbeatEvent;
    }

}
