package com.chrispie;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
@SpringBootTest(classes = MyApplication.class)
public class MyTests {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${addresses.multicast_topic_address}")
    private String myTopicAddress;

    @Test
    void testMe() {
        jmsTemplate.convertAndSend(myTopicAddress, "my custom message....");
    }
}
