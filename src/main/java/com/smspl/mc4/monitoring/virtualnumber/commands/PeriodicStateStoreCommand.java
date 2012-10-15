package com.smspl.mc4.monitoring.virtualnumber.commands;

import com.smspl.mc4.monitoring.util.DateFormatter;
import org.joda.time.DateTime;

/**
 * User: adam
 * Date: 11/10/12
 */
public abstract class PeriodicStateStoreCommand extends CheckStateStoreCommand {

    protected static DateTime due = null;
    protected static Integer periodInSeconds = 20;

    @Override
    protected void doPreExecute() {
        if( due == null ) makeDueNow();

        if( !isDue() )
            getLog().infof("%s due to run in %s", this.getClass().getSimpleName(), DateFormatter.printTimeRemaining(getHeartbeatEvent().getTime(), due));
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
        return getHeartbeatEvent().isDue(due);
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
