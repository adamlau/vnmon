package com.smspl.mc4.monitoring.virtualnumber.state;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 4/10/12
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
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
