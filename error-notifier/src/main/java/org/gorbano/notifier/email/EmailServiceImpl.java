package org.gorbano.notifier.email;

import ch.qos.logback.classic.spi.LoggingEventVO;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
    @Override
    public void send(LoggingEventVO loggingEvent) {
        System.out.println("Sending error to DL: Level: " + loggingEvent.getLevel() + ";Message: " + loggingEvent.getMessage());
    }
}
