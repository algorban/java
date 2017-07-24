package org.gorbano.notifier.listener;

import ch.qos.logback.classic.spi.LoggingEventVO;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.gorbano.notifier.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@Component
public class JmsQueueListener {

    @Autowired
    EmailService emailService;

    @JmsListener(destination = "${spring.activemq.inbound_queue}")
    public void onMessage(final Message message) throws JMSException {
        String messageData = null;
        //System.out.println("Received message " + message);
        String response = null;
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            messageData = textMessage.getText();
            System.out.println(messageData);
        } else if (message instanceof ObjectMessage) {
            LoggingEventVO loggingEventVO = (LoggingEventVO) ((ActiveMQObjectMessage)message).getObject();
            emailService.send(loggingEventVO);
        }
    }

}
