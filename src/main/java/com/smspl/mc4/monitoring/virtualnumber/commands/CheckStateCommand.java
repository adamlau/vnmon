package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

/**
 * User: adam
 * Date: 9/10/12
 */
public abstract class CheckStateCommand extends CheckStateStoreCommand {

    @Override
    protected final void doExecute() {
        for(CheckState state : checkStateStore.getStates())
        {
            if(accept(state))
                process(state);
        }
    }

    protected abstract boolean accept(CheckState state);
    protected abstract void process(CheckState state);
}
