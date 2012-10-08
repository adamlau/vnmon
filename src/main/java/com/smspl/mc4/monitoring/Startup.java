package com.smspl.mc4.monitoring;

import com.smspl.mc4.monitoring.virtualnumber.commands.RebuildCheckCommandStateCacheCommand;
import org.jboss.solder.logging.Logger;
import org.jboss.solder.servlet.WebApplication;
import org.jboss.solder.servlet.event.Destroyed;
import org.jboss.solder.servlet.event.Started;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
public class Startup {

    @Inject
    Logger log;

    @Inject
    HeartbeatEmitter heartbeatEmitter;

    @Inject
    RebuildCheckCommandStateCacheCommand rebuildCommand;

    public void onStartup(@Observes @Started WebApplication webapp) {
        log.info("************************** Application at " + webapp.getContextPath() + " ready to handle requests");
        rebuildCommand.execute();
        heartbeatEmitter.start();
    }

    public void onShutdown(@Observes @Destroyed WebApplication webapp)
    {
        log.info("************************** Application at " + webapp.getContextPath() + " stopping");
        heartbeatEmitter.stop();
    }
}
