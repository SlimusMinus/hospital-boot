package aston.group86.hospitalboot.KAFKA;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@Slf4j
public class AlertConsumer2 {

  public static void main(String[] args) {
    Properties kaProperties = new Properties();
    kaProperties.put("bootstrap.servers", "localhost:9092,localhost:9093, localhost:9094");
    kaProperties.put("key.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
    kaProperties.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
    kaProperties.put("schema.registry.url", "http://localhost:8081");
    kaProperties.put("group.id", "alert-consumer-group");

    KafkaConsumer<Long, Alert> consumer = new KafkaConsumer<Long, Alert>(kaProperties);
    consumer.subscribe(List.of("kinaction_schematest"));
    while (true) {
      ConsumerRecords<Long, Alert> records = consumer.poll(Duration.ofMillis(250));
      for (ConsumerRecord<Long, Alert> record : records) {
        log.info("kinaction_info Alert Content = {}", record.value().toString());
      }
    }
  }


}
