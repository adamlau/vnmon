package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.services.ErrorNotifier;
import com.smspl.mc4.monitoring.virtualnumber.config.TimeOutConfig;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * CheckStateCommand will iterate over the CheckStateStore and offer each entry
 * up for processing. It also allows for expiring and removal of the entry.
 * <p/>
 * Each entry can be accepted for execution using <code>accept(CheckState state)</code>
 * <p/>
 * Each entry once accpeted will be proccessed by <code>process(CheckState state)</code>
 * <p/>
 * User: adam
 * Date: 9/10/12
 */
public abstract class CheckStateCommand extends CheckStateStoreCommand {

    private int timeOutInSeconds = TimeOutConfig.DEFAULT_TIMEOUT;
    private ArrayList<CheckState> statesToRemove = new ArrayList<CheckState>();

    @Inject
    ErrorNotifier errorNotifier;

    @Override
    protected final void doExecute() {
        for (CheckState currentState : getCheckStateStore().getStates()) {
            if (accept(currentState))
                try {
                    process(currentState);
                } catch (Exception e) {
                    getLog().errorf("Error processing %s: %s", currentState.getStateId(), e.getMessage());
                    flagStateForRemoval(currentState, e.getMessage());
                }
        }
    }

    @Override
    protected void doPostExecute() {
        if (!statesToRemove.isEmpty()) {
            for (CheckState stateToRemove : statesToRemove) {
                getLog().infof("removing - %s: %s", stateToRemove.getStateId(), stateToRemove.toString() );
                getCheckStateStore().remove(stateToRemove);
                errorNotifier.notifyOfErrors( stateToRemove.getStatus(), stateToRemove.toString() );
            }
        }
    }

    protected TimeOutConfig getTimeOutConfig() {
        return new TimeOutConfig(getHeartbeatEvent(), timeOutInSeconds);
    }

    protected void flagStateForRemoval(CheckState state, String reason) {
        if (state != null && state.getStateId() != null) {
            state.setStatus(reason);
            statesToRemove.add(state);
        }
    }

    /**
     * Implement this method to indicate if the command should run for
     * the supplied CheckState entry.
     *
     * @param state the current CheckState entry about to be processed
     * @return true to indicate that the command should continue execution
     */
    protected abstract boolean accept(CheckState state);

    /**
     * Implement this method to do the actual command execution on the
     * supplied CheckState entry.
     *
     * @param state the current CheckState entry to be processed
     */
    protected abstract void process(CheckState state);
}
