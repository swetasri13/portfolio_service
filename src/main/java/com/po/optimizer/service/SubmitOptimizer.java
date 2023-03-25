package com.po.optimizer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;*/
import org.springframework.stereotype.Service;
import com.azure.messaging.servicebus.*;


@Service
//@EnableJms
public class SubmitOptimizer {

    private static final String QUEUE_NAME = "portfolio_req_queue";
    private static String connectionString = "Endpoint=sb://msgportfolio.servicebus.windows.net/;SharedAccessKeyName=portfolio;SharedAccessKey=4kUeHVttwCN4wqWLw8LtcOdun0eXvT0Nk+ASbPHgbSg=;EntityPath=portfolio_req_queue";
    private static final Logger LOGGER = LoggerFactory.getLogger(SubmitOptimizer.class);

  /* @Autowired
   private JmsTemplate jmsTemplate;*/

    public void sendMessage(long runId) {
        LOGGER.info("Sending message");
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .queueName(QUEUE_NAME)
                .buildClient();
        senderClient.sendMessage(new ServiceBusMessage("RunId="+ runId));
        LOGGER.info("Message sent");
        //jmsTemplate.convertAndSend(QUEUE_NAME, runId);
    }
    //@JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        LOGGER.info("Message received: {}", message);
    }

}
