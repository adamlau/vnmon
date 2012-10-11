package com.smspl.mc4.monitoring.virtualnumber.commands;

import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: adam
 * Date: 11/10/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class PeriodicStateStoreCommand extends CheckStateStoreCommand {

    protected static GregorianCalendar due = null;
    protected static Integer periodInSeconds = 20;

    @Override
    protected void doPreExecute() {
        if( due == null ) makeDueNow();
        log.infof("%s due to run after %s", this.getClass().getSimpleName(), due.getTime().toString());
    }

    @Override
    protected void doPostExecute() {
        setNextDue();
    }

    @Override
    protected boolean canExecute() {
        return isDue();
    }

    private boolean isDue() {
        boolean isDue = getHeartbeatEvent().isDue(due);
        return isDue;
    }

    private void makeDueNow()
    {
        due = getHeartbeatEvent().getDueNext(-1);
    }

    private void setNextDue()
    {
        due = getHeartbeatEvent().getDueNext(periodInSeconds);
    }

}
