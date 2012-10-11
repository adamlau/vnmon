package com.smspl.mc4.monitoring;

import org.jboss.solder.logging.Logger;
import org.jboss.solder.servlet.WebApplication;
import org.jboss.solder.servlet.event.Destroyed;
import org.jboss.solder.servlet.event.Started;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * User: adamlau
 * Date: 3/10/12
 */
@ApplicationScoped
public class Startup {

    @Inject
    Logger log;

    @Inject
    HeartbeatEmitter heartbeatEmitter;

    public void onStartup(@Observes @Started WebApplication webapp) {
        log.info("************************** Application at " + webapp.getContextPath() + " ready to handle requests");
        heartbeatEmitter.start();
    }

    public void onShutdown(@Observes @Destroyed WebApplication webapp)
    {
        log.info("************************** Application at " + webapp.getContextPath() + " stopping");
        heartbeatEmitter.stop();
    }
}
