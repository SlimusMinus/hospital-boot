package aston.group86.hospitalboot.KAFKA;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

public class KinactionStopConsumer implements Runnable {

  private final KafkaConsumer<String, String> consumer;
  private final AtomicBoolean stopping = new AtomicBoolean(false);

  public KinactionStopConsumer(KafkaConsumer<String, String> consumer) {
    this.consumer = consumer;
  }

  public void run() {
    try {
      consumer.subscribe(List.of("kinaction_promos"));

      while (!stopping.get()) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(250));
      }
    } catch (WakeupException e) {
      if (!stopping.get()) {
        throw e;
      }
    } finally {
      consumer.close();
    }
  }

  public void shutdown() {
    stopping.set(true);
    consumer.wakeup();
  }
}