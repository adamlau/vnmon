package com.smspl.mc4.monitoring.virtualnumber.state;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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

    private final ConcurrentHashMap<UUID,CheckCommandState> stateCache;

    public CheckCommandStateCache() {
        this.stateCache = new ConcurrentHashMap<UUID, CheckCommandState>();
    }

    public boolean isEmpty()
    {
        return (stateCache.isEmpty());
    }

    public void clear() {
        stateCache.clear();
    }

    public void addState(CheckCommandState state) {
        stateCache.put(state.getStateId(), state);
    }

    public void dumpCache()
    {
        for(CheckCommandState state : stateCache.values())
        {
            log.info("state: " + state.toString());
        }
    }

}
