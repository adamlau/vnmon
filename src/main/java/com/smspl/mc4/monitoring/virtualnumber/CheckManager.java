package com.smspl.mc4.monitoring.virtualnumber;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 3/10/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
@ApplicationScoped
public class CheckManager {

    @Inject
    Logger log;

    Instance<VirtualNumberTestConfig> checkConfigs;

    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(30);

    public void runChecks()
    {
        final Runnable checkRun = new Runnable() {
            @Override
            public void run() {
                for(VirtualNumberTestConfig config : checkConfigs)
                {
                    log.infof("config %s, freq %s: %s", config.getCheckInstance(), config.getCheckFrequency(), config.toString());
                }
            }
        };

        final ScheduledFuture<?> checkHandle = scheduler.scheduleWithFixedDelay(checkRun, 10, 10, TimeUnit.SECONDS);

        scheduler.schedule( new Runnable() {
            @Override
            public void run() {
                checkHandle.cancel(true);
            }
        } ,60, TimeUnit.SECONDS);
    }

}
