package aston.group86.hospitalboot.KAFKA;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

@Slf4j
public class AlertTrendingProducer {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    Properties kaProperties = new Properties();
    kaProperties.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094");
    kaProperties.put("key.serializer", AlertKeySerde.class.getName());
    kaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    kaProperties.put("partinioner.class", AlertLevelPartitioner.class.getName());

    try (Producer<Alert, String> producer = new KafkaProducer<>(kaProperties)) {
      Alert alert = new Alert(0, "Stage 33", "CRITICAL", "Stage 33 stopped");
      ProducerRecord<Alert, String> producerRecord = new ProducerRecord<>("kinaction_alerttrend", alert, alert.getAlertMessage());
      producer.send(producerRecord, new AlertCallback());
    }
  }

}
