package org.vgb.nats.pub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.nats.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class NatsPublisherService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Connection connection;

    public void publish(String topic, String msg) {
        logger.info("Publishing message [{}] to topic [{}]", msg, topic);
        connection.publish(topic, msg.getBytes(StandardCharsets.UTF_8));
    }


}
