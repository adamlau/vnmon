package com.smspl.mc4.monitoring;

import org.jboss.solder.logging.Logger;

import javax.ejb.Schedule;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 1/10/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventManager {

    @Inject
    Logger log;

    @Schedule(dayOfWeek="*", hour="*", minute = "*")
    public void performTasks()
    {
        log.info("performing tasks");
    }

}
