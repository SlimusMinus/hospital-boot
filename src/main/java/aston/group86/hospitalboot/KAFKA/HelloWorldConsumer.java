package aston.group86.hospitalboot.KAFKA;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

@Slf4j
public class HelloWorldConsumer {

  private volatile boolean keepConsuming = true;

  public static void main(String[] args) {
    Properties kaProperties = new Properties();
    kaProperties.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
    kaProperties.put("group.id", "kinaction_helloconsumer");
    kaProperties.put("enable.auto.commit", "true");
    kaProperties.put("auto.commit.interval.ms", "1000");
    kaProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    kaProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    HelloWorldConsumer helloWorldConsumer = new HelloWorldConsumer();
    helloWorldConsumer.consume(kaProperties);
    Runtime.getRuntime().addShutdownHook(new Thread(helloWorldConsumer::shutdown));
  }

  private void consume(Properties kaProperties) {
    try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(kaProperties)) {
      consumer.subscribe(List.of("kinaction_helloworld")
      );
      while (keepConsuming) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(250));

        for (ConsumerRecord<String, String> record : records) {
          log.info("kinaction_info offset = {}, kinaction_value = {}", record.offset(), record.value());
        }
      }
    }
  }

  private void shutdown() {
    keepConsuming = false;
  }

}
