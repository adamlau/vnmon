package com.smspl.mc4.monitoring;

import org.jboss.solder.logging.Logger;
import org.joda.time.Instant;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
//@Singleton
//@Startup
public class HeartbeatEmitter {
    @Inject
    Logger log;

    @Inject
    private Event<HeartbeatEvent> heartbeat;

//    @Schedule(hour="*", minute="*", second="*/10", persistent = false)
    public void emit() {
        log.infof("heartbeat: %s", Instant.now());
        heartbeat.fire(new HeartbeatEvent());
    }
}
