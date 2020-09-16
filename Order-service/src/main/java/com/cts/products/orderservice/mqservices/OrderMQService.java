package com.cts.products.orderservice.mqservices;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cts.products.orderservice.dto.OrderDTO;

@Service
public class OrderMQService {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${orderService.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${orderService.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(OrderDTO orderDTO) {
		rabbitTemplate.convertAndSend(exchange, routingkey, orderDTO);
		System.out.println("Send msg = " + orderDTO);
	    
	}

}
