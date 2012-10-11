package com.smspl.mc4.monitoring.virtualnumber;

import org.jboss.solder.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * User: adamlau
 * Date: 8/10/12
 */
@ApplicationScoped
public class VirtualNumberTestConfigManager {

    @Inject
    Logger log;

    // gets injected by beans.xml
    Instance<VirtualNumberTestConfig> checkConfigs;

    public Instance<VirtualNumberTestConfig> getConfigs()
    {
        return checkConfigs;
    }

    public void dumpVirtualNumberConfigs() {
        for (VirtualNumberTestConfig config : checkConfigs) {
            log.infof("\nmonitoring: %s", config.toString());
        }
    }

}
