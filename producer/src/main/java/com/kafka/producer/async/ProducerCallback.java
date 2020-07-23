package com.kafka.producer.async;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerCallback implements Callback {

    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (metadata != null) {
            System.out.printf("Partition: %d, Offset: %d", metadata.partition(), metadata.offset());
        } else {
            exception.printStackTrace();
        }
    }
}
