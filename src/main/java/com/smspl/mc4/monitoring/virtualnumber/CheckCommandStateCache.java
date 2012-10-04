package com.smspl.mc4.monitoring.virtualnumber;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 4/10/12
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class CheckCommandStateCache {

    private final ConcurrentHashMap<UUID,CheckCommandState> stateCache;

    private CheckCommandStateCache() {
        this.stateCache = new ConcurrentHashMap<UUID, CheckCommandState>();
    }
}
