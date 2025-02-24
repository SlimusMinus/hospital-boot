package aston.group86.hospitalboot.KAFKA;

import static org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter.ListenerMode.record;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class AuditConsumer {

  public static void main(String[] args) {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094");
    properties.put("acks", "all");
    properties.put("retries", "3");
    properties.put("max.in.flight.requests.per.connection", "1");
    properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties.put("enable.auto.commit", "false");

    try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)){

      consumer.subscribe(List.of("kinaction_audit"));

      while (true){ //keepConsuming
        ConsumerRecords<String, String> poll = consumer.poll(Duration.ofMillis(250));
        for(ConsumerRecord<String, String> record : poll){
          //OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(++record.offset(), "");
        }
      }
      /*Map<TopicPartition, OffsetAndMetadata> kaOffsetMap = new HashMap<>();
      kaOffsetMap.put(new TopicPartition("kinaction_audit", record.partition()), offsetMeta);
      consumer.commitSync(kaOffsetMap);*/
    }
  }
}
