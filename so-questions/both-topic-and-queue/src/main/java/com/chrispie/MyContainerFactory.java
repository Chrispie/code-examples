package com.chrispie;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;

@Component
public class MyContainerFactory extends DefaultJmsListenerContainerFactory {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private DefaultJmsListenerContainerFactoryConfigurer configurer;

    @Setter
    private String containerClientId;

    @PostConstruct
    public void init() {
        configurer.configure(this, connectionFactory);
        setPubSubDomain(true);
        setClientId(containerClientId);
        setSubscriptionDurable(true);
    }
}
