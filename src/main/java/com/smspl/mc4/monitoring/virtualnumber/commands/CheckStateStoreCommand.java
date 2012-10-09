package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.HeartbeatEvent;
import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 9/10/12
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class CheckStateStoreCommand implements CheckCommand {

    HeartbeatEvent heartbeatEvent;
    @Inject CheckStateStore checkStateStore;

    protected static GregorianCalendar due = new GregorianCalendar();
    protected static Integer periodInSeconds = 10;

    @Override
    public void execute(HeartbeatEvent heartbeatEvent)
    {
        this.heartbeatEvent = heartbeatEvent;
        if( canExecute() )
            doExecute();

        due.add(Calendar.SECOND, periodInSeconds);
    }

    protected HeartbeatEvent getHeartbeatEvent()
    {
        return this.heartbeatEvent;
    }

    protected CheckStateStore getCheckStateStore()
    {
        return this.checkStateStore;
    }

    protected abstract void doExecute();
    protected boolean canExecute() { return true; }

    protected boolean isDue() {
        return getHeartbeatEvent().isDue(due);
    }
}
