package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;
import org.jboss.solder.logging.Logger;

import javax.inject.Inject;

/**
 * CheckStateStoreCommand exposes the CheckStateStore so that it can be manipulated
 * as a whole. It uses the following template to execute the command:
 * <pre>
 * {@code
 * doPreExecute();
 * if (canExecute()) {
 *  doExecute();
 *  doPostExecute();
 *  }
 * }
 * </pre>
 *
 * User: adam
 * Date: 9/10/12
 */
public abstract class CheckStateStoreCommand implements CheckCommand {

    private HeartbeatEvent heartbeatEvent;

    @Inject
    private CheckStateStore checkStateStore;

    @Inject
    private Logger log;

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

    /**
     * Default action: nothing
     * Use this method to set up any state that may be required for the command
     * to run. Is executed before @see canExecute() .
     */
    protected void doPreExecute() { }

    /**
     * Default action: returns true
     * Use this method to indicate that the command should be executed.
     * doPreExecute();
     * @return Default true. Indicates that the command can be executed.
     */
    protected boolean canExecute() { return true; }

    /**
     * Use this method to do the actual work for the command
     */
    protected abstract void doExecute();

    /**
     * Default action: nothing
     * Use this method to set any command state after execution has taken place.
     */
    protected void doPostExecute() { }

    protected CheckStateStore getCheckStateStore() {
        return checkStateStore;
    }

    protected Logger getLog() {
        return log;
    }
}
