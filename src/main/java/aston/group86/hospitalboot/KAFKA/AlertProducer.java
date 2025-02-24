package aston.group86.hospitalboot.KAFKA;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class AlertProducer {

  public static void main(String[] args) {

    Properties kaProperties = new Properties();
    kaProperties.put("bootstrap.servers", "localhost:9092,localhost:9093");
    kaProperties.put("key.serializer", AlertKeySerde.class.getName());
    kaProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    kaProperties.put("partitioner.class", AlertLevelPartitioner.class.getName());
    kaProperties.put("interceptor.classes", AlertProducerMetricsInterceptor.class.getName());

    try (Producer<Alert, String> producer = new KafkaProducer<>(kaProperties)) {
      Alert alert = new Alert(1, "Stage 1", "CRITICAL", "Stage 1 stopped");
      ProducerRecord<Alert, String> producerRecord = new ProducerRecord<>("kinaction_alert", alert, alert.getAlertMessage());
      producer.send(producerRecord, new AlertCallback());
    }
  }

}
