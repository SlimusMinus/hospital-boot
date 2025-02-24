package aston.group86.hospitalboot.KAFKA;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;

@Slf4j
public class AlertConsumerMetricsInterceptor implements ConsumerInterceptor<Alert, String> {

  @Override
  public ConsumerRecords<Alert, String> onConsume(ConsumerRecords<Alert, String> consumerRecords) {
    if (consumerRecords.isEmpty()) {
      return consumerRecords;
    } else {
      for (ConsumerRecord<Alert, String> record : consumerRecords) {
        Headers headers = record.headers();
        for (Header header : headers) {
          if ("kinactionTraceId".equals(header.key())) {
            log.info("KinactionTraceId is: " + new String(header.value()));
          }
        }
      }
    }
    return consumerRecords;
  }

  @Override
  public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {

  }

  @Override
  public void close() {

  }

  @Override
  public void configure(Map<String, ?> map) {

  }
}
