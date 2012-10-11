package com.smspl.mc4.monitoring.virtualnumber.state;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * User: adamlau
 * Date: 4/10/12
 */
@ApplicationScoped
public class CheckStateStore {

    @Inject
    Logger log;

    private final ArrayList<CheckState> stateCache;

    public CheckStateStore() {
        this.stateCache = new ArrayList<CheckState>();
    }

    public boolean isEmpty()
    {
        return (stateCache.isEmpty());
    }

    public void clear() {
        stateCache.clear();
    }

    public void addState(CheckState state) {
        stateCache.add(state);
    }

    public void dumpCache()
    {
        for(CheckState state : stateCache)
        {
            log.info("state: " + state.toString());
        }
    }

    public Collection<CheckState> getStates()
    {
        return this.stateCache;
    }
}
