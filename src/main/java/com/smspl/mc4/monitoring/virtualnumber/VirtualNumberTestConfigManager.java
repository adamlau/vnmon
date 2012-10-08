package com.smspl.mc4.monitoring.virtualnumber;

import org.jboss.solder.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: adamlau
 * Date: 8/10/12
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
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
