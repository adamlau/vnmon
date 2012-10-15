package com.smspl.mc4.monitoring.virtualnumber;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.commands.*;
import org.jboss.solder.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * User: adam
 * Date: 9/10/12
 */
public class VirtualNumberCheckExecutor {

    @Inject Logger log;
    @Inject ExpireNewChecksCommand expireNewChecksCommand;
    @Inject AddNewChecksCommand addNewChecksCommand;
    @Inject SubmitSmsForNewChecks submitSmsForNewChecks;
    @Inject CheckDeliveryReceiptResponseTime checkDeliveryReceiptResponseTime;
    @Inject CheckInboundSmsResponseTime checkInboundSmsResponseTime;
    @Inject ExpireCompletedChecks expireCompletedChecks;
    @Inject DumpCacheCommand dumpCacheCommand;

    public void runChecks(@Observes HeartbeatEvent heartbeatEvent) {
        log.info("Running checks...");
        expireNewChecksCommand.execute(heartbeatEvent);
        addNewChecksCommand.execute(heartbeatEvent);
        submitSmsForNewChecks.execute(heartbeatEvent);
        checkDeliveryReceiptResponseTime.execute(heartbeatEvent);
        checkInboundSmsResponseTime.execute(heartbeatEvent);
        expireCompletedChecks.execute(heartbeatEvent);
        dumpCacheCommand.execute(heartbeatEvent);
        log.info("Finished checks...");
    }
}
