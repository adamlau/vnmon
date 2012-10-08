package com.smspl.mc4.monitoring;

import org.jboss.solder.logging.Logger;
import org.joda.time.Instant;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeartbeatEmitter {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Long initialDelay = 20l;
    Long periodInSeconds = 60l;

    ScheduledFuture<?> emitterHandle = null;

    @Inject
    Logger log;

    @Inject
    private Event<HeartbeatEvent> heartbeat;

    public void start() {
        log.infof("Starting HeartbeatEmitter. Observe the HeartbeatEvent to subscribe.", Instant.now());

        final Runnable emitter = new Runnable() {
            @Override
            public void run() {
                log.infof("heartbeat: %s", Instant.now());
                heartbeat.fire(new HeartbeatEvent());
            }
        };

        emitterHandle = scheduler.scheduleAtFixedRate(emitter, initialDelay, periodInSeconds, TimeUnit.SECONDS);
    }

    public void stop() {
        if( emitterHandle != null )
        {
            log.info("Stopping HeartbeatEmitter.");
            emitterHandle.cancel(true);
        }
    }
}
