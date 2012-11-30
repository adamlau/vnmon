package com.smspl.mc4.monitoring.virtualnumber.state;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
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
    private final ArrayList<CheckState> removedStateCache;

    public CheckStateStore() {
        this.stateCache = new ConcurrentHashMap<UUID,CheckState>();
        this.removedStateCache = new ArrayList<CheckState>();
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

    public Collection<CheckState> getStates()
    {
        return this.stateCache.values();
    }

    public Collection<CheckState> getRemovedStates()
    {
        return this.removedStateCache;
    }

    public CheckState get(UUID stateId)
    {
        return this.stateCache.get(stateId);
    }

    public CheckState getByDocumentId(String documentId) {
        CheckState foundCheckState = null;
        for (CheckState checkState : this.stateCache.values()) {
            if( documentId.compareTo(checkState.getDocumentId()) == 0 )
            {
                foundCheckState = checkState;
            }
        }
        return foundCheckState;
    }

    public void remove(CheckState stateToRemove ) {
        if( stateToRemove != null )
        {
            removedStateCache.add(0, stateToRemove);
            if(removedStateCache.size() > 100)
                for(int i = removedStateCache.size() - 1; i >= 100; --i )
                    if( removedStateCache.get(i) != null) removedStateCache.remove(i);
            stateCache.remove(stateToRemove.getStateId());
        }

    }
}
