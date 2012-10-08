package com.smspl.mc4.monitoring.virtualnumber;

import org.jboss.solder.logging.Logger;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CheckManager {

    @Inject
    Logger log;

    @Inject
    RebuildCheckCommandStateCacheCommand rebuildCommand;

    @Inject
    CheckCommandStateCache checkCommandStateCache;

    public void start()
    {
        rebuildCacheIfEmpty();
    }

//    public void runChecks(@Observes HeartbeatEvent heartbeatEvent) {
//        log.infof("received heartbeat at: %s", Instant.now());
//        rebuildCacheIfEmpty();
//    }

    private void rebuildCacheIfEmpty()
    {
        if( checkCommandStateCache.isEmpty() )
        {
            rebuildCommand.execute(checkCommandStateCache);
        }
    }

}
