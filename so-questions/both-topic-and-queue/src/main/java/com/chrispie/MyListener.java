package com.chrispie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener {

    @Value("${addresses.multicast_topic_address}")
    private String myTopicAddress;

    @JmsListener(destination = "${addresses.multicast_topic_address}",
            containerFactory = "myContainerFactory",
            subscription = "${addresses.multicast_topic_address}")
    public void processMsg(final String message) {
        log.info("============= Received: " + message);
    }
}
