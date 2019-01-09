package com.tensquare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rp
 * @create 2019/1/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("ruipeng","我要红包");
    }


    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("rp","", "分列模式走起");
    }

    @Test
    public void test1(){
        System.out.println("============");
    }
}