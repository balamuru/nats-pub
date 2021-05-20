package org.vgb.nats.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class NatsPubApplication implements ApplicationRunner {

    @Autowired
    private NatsPublisherService natsPublisherService;

    @Value("${nats.topic}")
    private String topic;

    @Value("${nats.msg}")
    private String msg;

    public static void main(String[] args) {
        SpringApplication.run(NatsPubApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        while (true) {

            natsPublisherService.publish(topic, msg);
            Thread.sleep(5000);
        }
    }
}
