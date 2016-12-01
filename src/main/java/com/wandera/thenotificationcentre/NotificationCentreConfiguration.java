package com.wandera.thenotificationcentre;

import io.dropwizard.Configuration;
import javax.validation.Valid;

public class NotificationCentreConfiguration extends Configuration {
    
    @Valid
    private NotificationConfiguration messages;

    public NotificationConfiguration getMessages() {
        return messages;
    }

    public void setMessages(NotificationConfiguration messages) {
        this.messages = messages;
    }
}
