package com.smspl.mc4.monitoring.virtualnumber.state;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 4/10/12
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
public class CheckCommandStateCache {

    @Inject
    Logger log;

    private final ArrayList<CheckCommandState> stateCache;

    public CheckCommandStateCache() {
        this.stateCache = new ArrayList<CheckCommandState>();
    }

    public boolean isEmpty()
    {
        return (stateCache.isEmpty());
    }

    public void clear() {
        stateCache.clear();
    }

    public void addState(CheckCommandState state) {
        stateCache.add(state);
    }

    public void dumpCache()
    {
        for(CheckCommandState state : stateCache)
        {
            log.info("state: " + state.toString());
        }
    }

}
