package com.smspl.mc4.monitoring.services;

import org.jboss.solder.logging.Logger;

import javax.inject.Inject;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 3:47 PM
 */
public class ErrorNotifier {

    @Inject ErrorNotifierConfig notifierConfig;
    @Inject SMSSubmitService smsSubmitService;
    @Inject MailerService mailerService;
    @Inject Logger log;

    public void notifyOfErrors(String subject, String errorText)
    {
        sendSMS(subject + ": " + errorText);
        sendEmail(subject, errorText);
    }

    private void sendEmail(String subject, String errorText)
    {
        String mailSubject = ( subject !=null ) ? subject : "(no subject)";
        if(notifierConfig.getEmailRecipients() != null)
            for(String recipient : notifierConfig.getEmailRecipients())
            {
                log.infof("notifying by email: %s", recipient);
                mailerService.send(recipient,"vnmon error notification - " + mailSubject, errorText);
            }
    }

    private void sendSMS(String message)
    {
        if(notifierConfig.getMobileRecipients() != null)
            for(String recipient : notifierConfig.getMobileRecipients())
            {
                log.infof("notifying by sms: %s", recipient);
                smsSubmitService.submit(notifierConfig.getUsername(), notifierConfig.getPassword(), recipient, message, null);
            }
    }
}
