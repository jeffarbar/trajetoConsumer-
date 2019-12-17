package br.com.send.consumer.mq.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class ConsumerService {

	private static final Logger logger = LogManager.getLogger(ConsumerService.class);
	
	@Autowired
	private ProcessarService processarService;
	
	@RabbitListener(queues = {"${rabbitmq.queue}"})
    public void receive(@Payload String msg) throws Exception {
      
		logger.info(msg);
		
		processarService.processa(msg);
    }
}
