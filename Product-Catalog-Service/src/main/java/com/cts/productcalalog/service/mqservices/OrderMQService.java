package com.cts.productcalalog.service.mqservices;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cts.productcalalog.service.domain.InventoryDomain;
import com.cts.productcalalog.service.dto.OrderDTO;


@Service
public class OrderMQService {
	
	@Autowired
	InventoryDomain inventoryDomain;
	
	@Value("${orderService.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${orderService.rabbitmq.routingkey}")
	private String routingkey;	
	
	@Value("${orderService.rabbitmq.queue}")
	String queueName;
	
	@RabbitListener(queues = "${orderService.rabbitmq.queue}")
    public void receiveMessage(final OrderDTO orderDTo) {
		inventoryDomain.updateInventory(orderDTo);
        System.out.println("Updated Inventory");
    }

}
