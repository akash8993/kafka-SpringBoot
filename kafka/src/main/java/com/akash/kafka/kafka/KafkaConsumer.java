package com.akash.kafka.kafka;

import com.akash.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//Ye hai for consuming the data and subscribe to the topic to perform
@Service
public class KafkaConsumer {

    private static final Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "topicTest", groupId = "myGroup")
    public void consumeMessage(String message)
    {
        logger.info(String.format("Message Received %s", message));
    }

    @KafkaListener(topics = "topicTest_json", groupId = "myGroup")
    public void consumeMessageJson(User user)
    {
        logger.info(String.format("Message Received with id %s, first Name as %s, last Name as %s", user.getId(), user.getFirstName(),
                user.getLastName()));
    }
}
