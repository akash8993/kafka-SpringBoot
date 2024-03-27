package com.akash.kafka.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//Here with this class we will produce the messsage and then put it to the topics.
//Here with help of template it will send the message to topic from producer
@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private static final Logger logger= LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message)
    {
        logger.info(String.format("Message sent %s",message));
        kafkaTemplate.send("topicTest",message);
    }
}
