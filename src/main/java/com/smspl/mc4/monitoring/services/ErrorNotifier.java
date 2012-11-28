package com.smspl.mc4.monitoring.services;

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

    public void notifyOfErrors(String subject, String errorText)
    {
        sendSMS(subject + ": " + errorText);
        sendEmail(subject, errorText);
    }

    private void sendEmail(String subject, String errorText)
    {
        for(String recipient : notifierConfig.getEmailRecipients())
        {
            mailerService.send(recipient,"vnmon error notification - " + subject, errorText);
        }
    }

    private void sendSMS(String message)
    {
        for(String recipient : notifierConfig.getMobileRecipients())
        {
            smsSubmitService.submit(notifierConfig.getUsername(), notifierConfig.getPassword(), recipient, message, null);
        }
    }
}
