package com.smspl.mc4.monitoring;

import com.smspl.mc4.monitoring.virtualnumber.SendTestSMSTask;
import org.jboss.solder.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 1/10/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class EventManager {

    @Inject
    Logger log;

    @Inject
    SendTestSMSTask smsTask;

    @Schedule(dayOfWeek="*", hour="*", minute = "*", persistent = false)
    public void performTasks()
    {
        log.info("performing tasks");
        smsTask.sendSMS();
    }

}
