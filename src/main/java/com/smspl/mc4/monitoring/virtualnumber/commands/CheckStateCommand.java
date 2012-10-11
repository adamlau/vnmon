package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckState;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 9/10/12
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
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
