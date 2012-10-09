package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import org.jboss.solder.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 9/10/12
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandExecutor {

    @Inject Logger log;
    @Inject AddNewChecksCommand addNewChecksCommand;

    public void runChecks(@Observes HeartbeatEvent heartbeatEvent) {

        addNewChecksCommand.execute(heartbeatEvent);
        //add new checks if heartbeart event is due
        //submit messages for new checks
        //check submit responses expiry - add to errors  and remove
        //check delivery response expiry - add to errors and remove
        //check push deliver sm expiry   - add to errors and remove
    }
}
