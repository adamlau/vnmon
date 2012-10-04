package com.smspl.mc4.monitoring.virtualnumber;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import org.jboss.solder.logging.Logger;
import org.joda.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
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

    Instance<VirtualNumberTestConfig> checkConfigs;

    public void runChecks(@Observes HeartbeatEvent heartbeatEvent) {
        log.infof("received heartbeat at: %s", Instant.now());

        for (VirtualNumberTestConfig config : checkConfigs) {
            log.infof("config %s, freq %s: %s", config.getCheckInstance(), config.getCheckFrequency(), config.toString());
        }
    }

}
