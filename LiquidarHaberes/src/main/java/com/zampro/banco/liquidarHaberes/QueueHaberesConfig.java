package com.zampro.banco.liquidarHaberes;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

public class QueueHaberesConfig {
	
	@Value("${activemq.broker.url}")
	String urlBroker;
	
	@Value("${activemq.broker.queue}")
	String cola;
	
	@Bean
	Queue cola() {
		return new ActiveMQQueue(cola);
	}
	
	@Bean
	ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(urlBroker);
	}
	
	@Bean
	JmsTemplate jmsTemplete() {
		return new JmsTemplate(connectionFactory());
	}

}
