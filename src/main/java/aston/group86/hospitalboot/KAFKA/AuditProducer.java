package aston.group86.hospitalboot.KAFKA;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

@Slf4j
public class AuditProducer {

  public static void main(String[] args) {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094");
    properties.put("acks", "all");
    properties.put("retries", "3");
    properties.put("max.in.flight.requests.per.connection", "1");
    properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    try (Producer<String, String> producer = new KafkaProducer<>(properties)) {

      ProducerRecord<String, String> producerRecord = new ProducerRecord<>("kinaction_helloworld",
          null, "hello world again!");
      RecordMetadata result = producer.send(producerRecord).get();
      log.info("kinaction_info offset = {}, topic = {}, timestamp = {}", result.offset(), result.topic(), result.timestamp());
      producer.close();


    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
