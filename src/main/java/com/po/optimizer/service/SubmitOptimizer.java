package com.po.optimizer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SubmitOptimizer {

    private static final String QUEUE_NAME = "portfolio_req_queue";

    private static final Logger LOGGER = LoggerFactory.getLogger(SubmitOptimizer.class);
    /*@Autowired
    private JmsTemplate jmsTemplate;
*/
    public void sendMessage(long runId) {
        LOGGER.info("Sending message");
       // jmsTemplate.convertAndSend(QUEUE_NAME, runId);
    }

}
