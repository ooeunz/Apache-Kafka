package com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);

        Properties prpos = new Properties();
        prpos.put("bootstrap.servers", "127.0.0.1:9092");
        prpos.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        prpos.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(prpos);
        producer.send(new ProducerRecord<String, String>("kafka-my-topic", "Apache Kafka Producer Test"));

        producer.close();
    }

}
