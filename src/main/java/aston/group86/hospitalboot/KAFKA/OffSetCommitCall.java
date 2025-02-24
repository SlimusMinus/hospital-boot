package aston.group86.hospitalboot.KAFKA;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.common.TopicPartition;

@Slf4j
public class OffSetCommitCall implements OffsetCommitCallback {

  public static void commitOffset(long offset, int partition, String topic, KafkaConsumer<String, String> consumer) {
    OffsetAndMetadata offsetMeta = new OffsetAndMetadata(++offset, "");

    Map<TopicPartition, OffsetAndMetadata> kaOffsetMap = new HashMap<>();

    kaOffsetMap.put(new TopicPartition(topic, partition), offsetMeta);

    consumer.commitAsync(kaOffsetMap, (map, e) -> {
      if (e != null) {
        for (TopicPartition key : map.keySet()) {
          log.info("kinaction_error: offset {}", map.get(key).offset());
        }
      } else {
        for (TopicPartition key : map.keySet()) {
          log.info("kinaction_info: offset {}", map.get(key).offset());
        }
      }
    });
  }

  @Override
  public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {

  }
}
