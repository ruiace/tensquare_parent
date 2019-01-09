package com.tensquare.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="ruipeng2" )
public class Customer2 {
@RabbitHandler
public void showMessage(String message){
System.out.println("ruipeng2接收到消息："+message);
}
}