package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;

/**
 * CheckStateStoreCommand expose the CheckStateStore so that it can be manipulated
 * as a whole.
 *
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

    protected HeartbeatEvent getHeartbeatEvent() {
        return this.heartbeatEvent;
    }

    /// methods that can be overridden/implemented in concrete commands

    /**
     * Use this method to set up any state that may be required for the command
     * to run. Is executed before @see canExecute() .
     * Default action: nothing
     *
     * doPreExecute();
     * if (canExecute()) {
     *  doExecute();
     *  doPostExecute();
     *  }
     */
    protected void doPreExecute() { }

    /**
     * Use this method to indicate that the command should be executed.
     * doPreExecute();
     * Default action: returns true
     *
     * if (canExecute()) {
     *  doExecute();
     *  doPostExecute();
     *  }
     * @return Default true. Indicates that the command can be executed.
     */
    protected boolean canExecute() { return true; }

    /**
     * Use this method to do the actual work for the command
     */
    protected abstract void doExecute();

    /**
     * Use this method to set command state after execution has taken place.
     * Default action: nothing
     *
     * if (canExecute()) {
     *  doExecute();
     *  doPostExecute();
     *  }
     */
    protected void doPostExecute() { }

}
