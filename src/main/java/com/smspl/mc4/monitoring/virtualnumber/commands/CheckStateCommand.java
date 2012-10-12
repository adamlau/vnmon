package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * CheckStateCommand will iterate over the CheckStateStore and offer each entry
 * up for processing.
 * <p/>
 * Each entry can be accepted for execution using <code>accept(CheckState state)</code>
 * <p/>
 * Each entry once accpeted will be proccessed by <code>process(CheckState state)</code>
 * <p/>
 * User: adam
 * Date: 9/10/12
 */
public abstract class CheckStateCommand extends CheckStateStoreCommand {

    private ArrayList<UUID> statesToRemove = new ArrayList<UUID>();

    @Override
    protected final void doExecute() {
        for (CheckState currentState : getCheckStateStore().getStates()) {
            if (accept(currentState))
                try {
                    process(currentState);
                } catch (Exception e) {
                    flagStateForRemoval(currentState);
                }
        }
    }

    @Override
    protected void doPostExecute() {
        // todo: add to error notifier
        for (UUID stateId : statesToRemove) {
            getCheckStateStore().remove(stateId);
        }
    }

    protected boolean stateTimedOut(GregorianCalendar stateTime, int timeOutInSeconds) {
        return getHeartbeatEvent().hasExpired(stateTime, timeOutInSeconds);
    }

    protected void flagStateForRemoval(CheckState state)
    {
        if( state != null && state.getStateId() != null )
        {
            getLog().infof("Removing state %s", state.toString() );
            statesToRemove.add(state.getStateId());
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
