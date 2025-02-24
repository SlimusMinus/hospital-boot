package aston.group86.hospitalboot.KAFKA;

import static aston.group86.hospitalboot.KAFKA.OffSetCommitCall.commitOffset;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.TopicPartition;

public class AlertLevelPartitioner implements Partitioner {

  /*KafkaConsumer<Alert, String> consumer = new KafkaConsumer<Alert, String>(kaProperties);
  TopicPartition partitionZero = new TopicPartition("kinaction_alert", 0);
  consumer.assign(List.of(partitionZero));
  while(true)  {
    ConsumerRecords<Alert, String> records = consumer.poll(Duration.ofMillis(250));
    for (ConsumerRecord<Alert, String> record : records) {
      // ...
      commitOffset(record.offset(), record.partition(), topicName, consumer);
    }
  }*/

  /*public static void commitOffset(long offset,int part, String topic,
      KafkaConsumer<Alert, String> consumer) {
    OffsetAndMetadata offsetMeta = new OffsetAndMetadata(++offset, "");

    Map<TopicPartition, OffsetAndMetadata> kaOffsetMap = new HashMap<TopicPartition, OffsetAndMetadata>();
    kaOffsetMap.put(new TopicPartition(topic, part), offsetMeta);
    OffsetCommitCallback callback = new OffsetCommitCallback() { };
    consumer.commitAsync(kaOffsetMap, callback);
  }*/

  @Override
  public int partition(String topic, Object objectKey, byte[] bytes, Object o1, byte[] bytes1,
      Cluster cluster) {
    int criticalLevelPartition = findCriticalPartitionNumber(cluster, topic);

    // Проверяем, критический ли уровень
    if (isCriticalLevel(AlertStatus.valueOf(((Alert) objectKey).getAlertLevel()))) {
      return criticalLevelPartition;
    }

    // Если не критический, выбираем случайный раздел
    return findRandomPartition(cluster, topic, objectKey);
  }

  @Override
  public void close() {

  }

  @Override
  public void configure(Map<String, ?> map) {

  }

  private int findCriticalPartitionNumber(Cluster cluster, String topic) {
    // Предположим, критический раздел всегда номер 0
    return 0;
  }

  private boolean isCriticalLevel(AlertStatus alertLevel) {
    // Например, считаем критическим уровнем значение CRITICAL
    return alertLevel == AlertStatus.Critical;
  }

  // Метод для выбора случайного раздела
  private int findRandomPartition(Cluster cluster, String topic, Object objectKey) {
    // Получаем количество разделов
    int numPartitions = cluster.partitionsForTopic(topic).size();

    // Генерируем случайный номер раздела (не 0, если 0 зарезервирован для критических)
    return (int) (Math.random() * (numPartitions - 1)) + 1;
  }
}
