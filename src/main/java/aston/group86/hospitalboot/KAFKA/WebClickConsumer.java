package aston.group86.hospitalboot.KAFKA;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@Slf4j
public class WebClickConsumer {

  private volatile boolean keepConsuming = true;

  public static void main(String[] args) {
    Properties kaProperties = new Properties();
    kaProperties.put("bootstrap.servers", "localhost:9092,localhost:9093,,localhost:9094");
    kaProperties.put("group.id","kinaction_webconsumer");
    kaProperties.put("enable.auto.commit", "true");
    kaProperties.put("auto.commit.interval.ms", "1000");
    kaProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    kaProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    WebClickConsumer webClickConsumer = new WebClickConsumer();
    webClickConsumer.consume(kaProperties);
    Runtime.getRuntime().addShutdownHook(new Thread(webClickConsumer::shutdown));
  }

  private void consume(Properties kaProperties) {
    try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kaProperties)) {
      consumer.subscribe( List.of("kinaction_promos") );
      while (keepConsuming) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(250));
        for (ConsumerRecord<String, String> record : records) {
          log.info("kinaction_info offset = {}, key = {}", record.offset(),   record.key());
          log.info("kinaction_info value = {}", Double.parseDouble(record.value()) * 1.543);
        }
      }
    }
  }

  private void shutdown() {
    keepConsuming = false;
  }
}