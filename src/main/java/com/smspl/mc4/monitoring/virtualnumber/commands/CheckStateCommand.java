package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * CheckStateCommand will iterate over the CheckStateStore and offer each entry
 * up for processing.
 * Each entry can be accepted for execution - @see accept(CheckState state)
 * and processed - @see process(CheckState state)
 *
 * User: adam
 * Date: 9/10/12
 */
public abstract class CheckStateCommand extends CheckStateStoreCommand {

    @Override
    protected final void doExecute() {
        Iterator<Map.Entry<UUID,CheckState>> stateIterator = checkStateStore.getStates().iterator();
        while(stateIterator.hasNext())
        {
            CheckState currentState = stateIterator.next().getValue();
            if(accept(currentState))
                try
                {
                    process(currentState);
                } catch (Exception e)
                {
                    // todo: add to error notifier
                    stateIterator.remove();
                }
        }
    }

    /**
     * Implement this method to indicate if the command should run for
     * the supplied CheckState entry.
     * @param state the current CheckState entry about to be processed
     * @return true to indicate that the command should continue execution
     */
    protected abstract boolean accept(CheckState state);

    /**
     * Implement this method to do the actual command execution on the
     * supplied CheckState entry.
     * @param state the current CheckState entry to be processed
     */
    protected abstract void process(CheckState state);
}
