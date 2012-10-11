package com.smspl.mc4.monitoring.virtualnumber.state;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: adamlau
 * Date: 4/10/12
 */
@ApplicationScoped
public class CheckStateStore {

    @Inject
    Logger log;

    private final ConcurrentHashMap<UUID,CheckState> stateCache;

    public CheckStateStore() {
        this.stateCache = new ConcurrentHashMap<UUID,CheckState>();
    }

    public boolean isEmpty()
    {
        return (stateCache.isEmpty());
    }

    public void clear() {
        stateCache.clear();
    }

    public void addState(CheckState state) {
        stateCache.put(state.getStateId(), state);
    }

    public void dumpCache()
    {
        for(CheckState state : stateCache.values())
        {
            log.info("state: " + state.toString());
        }
    }

    public Set<Map.Entry<UUID, CheckState>> getStates()
    {
        return this.stateCache.entrySet();
    }

    public CheckState get(UUID stateId)
    {
        return this.stateCache.get(stateId);
    }

}
