package com.akash.kafka.kafka;

import com.akash.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${spring.kafka.topic.name.json}")
    private String topicName;
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user)
    {
        logger.info(String.format("Message sent %s %s %s",user.getId(), user.getFirstName(),
                user.getLastName()));

        Message<User> message= MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,
                topicName).build();

        kafkaTemplate.send(message);
    }
}
