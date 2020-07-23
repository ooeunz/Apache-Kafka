package com.kafka.producer;

import com.kafka.producer.async.ProducerCallback;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class ProducerApplication {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        try {
            producer.send(new ProducerRecord<String, String>("kafka-my-topic", "Apache Kafka Producer Test"), new ProducerCallback());
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            producer.close();
        }
    }
}

// TODO Sync 전송
//public class ProducerApplication {
//
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "127.0.0.1:9092");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        Producer<String, String> producer = new KafkaProducer<String, String>(props);
//        try {
//            RecordMetadata metadata = producer.send(new ProducerRecord<String, String>("kafka-my-topic", "Apache Kafka Producer Test")).get();
//            System.out.printf("Partition: %d, Offset %d", metadata.partition(), metadata.offset());
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        } finally {
//            producer.close();
//        }
//    }
//}

// TODO 전송 결과 확인하지 않기
//public class ProducerApplication {
//
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "127.0.0.1:9092");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        Producer<String, String> producer = new KafkaProducer<String, String>(props);
//        try {
//            producer.send(new ProducerRecord<String, String>("kafka-my-topic", "Apache Kafka Producer Test"));
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        } finally {
//            producer.close();
//        }
//    }
//}

//@SpringBootApplication
//        SpringApplication.run(ProducerApplication.class, args);
