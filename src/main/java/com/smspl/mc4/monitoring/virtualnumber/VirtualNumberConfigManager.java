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
public class VirtualNumberConfigManager {

    @Inject
    Logger log;

    // gets injected by beans.xml
    Instance<VirtualNumberConfig> checkConfigs;

    public Instance<VirtualNumberConfig> getConfigs()
    {
        return checkConfigs;
    }

    public void dumpVirtualNumberConfigs() {
        for (VirtualNumberConfig config : checkConfigs) {
            log.infof("\nmonitoring: %s", config.toString());
        }
    }

}
