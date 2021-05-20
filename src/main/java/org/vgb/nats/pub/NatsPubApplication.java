package org.vgb.nats.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication

public class NatsPubApplication implements ApplicationRunner {

    @Autowired
    private NatsPublisherService natsPublisherService;

    @Value("${nats.topic}")
    private String topic;

    @Value("${nats.msg}")
    private String msg;

    public static void main(String[] args) {
        new SpringApplicationBuilder(NatsPubApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int i = 0;
        while (true) {
        i = (++i)%1000;
            natsPublisherService.publish(topic, msg+"-"+i);
            Thread.sleep(5000);
        }
    }
}
