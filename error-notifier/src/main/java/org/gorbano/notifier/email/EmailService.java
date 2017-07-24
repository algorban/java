package org.gorbano.notifier.email;

import ch.qos.logback.classic.spi.LoggingEventVO;

public interface EmailService {
    void send(LoggingEventVO loggingEvent);
}
