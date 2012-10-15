package com.smspl.mc4.monitoring.services;

import org.jboss.seam.mail.api.MailMessage;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 4:26 PM
 */
public class MailerService {

    @Inject ErrorNotifierConfig errorNotifierConfig;
    @Inject
    Instance<MailMessage> mailMessage;

    public void send(String recipient, String subject, String message)
    {
        mailMessage.get()
                .from("vnmon@smartmessagingservices.net")
                .to(recipient)
                .subject(subject)
                .bodyText(message)
                .send();
    }
}
