package com.tensquare.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
    @RabbitListener(queues="ruipeng" )
    public class Customer {
        @RabbitHandler
        public void showMessage(String message){
            System.out.println("ruipeng接收到消息："+message);
        }
    }