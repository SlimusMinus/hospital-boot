package aston.group86.hospitalboot.KAFKA;

import static org.springframework.integration.kafka.inbound.KafkaMessageDrivenChannelAdapter.ListenerMode.record;

import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Headers;

@Slf4j
public class AlertProducerMetricsInterceptor implements ProducerInterceptor<Alert, String> {

  @Override
  public ProducerRecord<Alert, String> onSend(ProducerRecord<Alert, String> producerRecord) {
    Headers headers = producerRecord.headers();
    String kinactionTraceId = UUID.randomUUID().toString();
    headers.add("kinactionTraceId", kinactionTraceId.getBytes());
    log.info("kinaction_info Created kinactionTraceId: {}", kinactionTraceId);
    return producerRecord;

  }

  @Override
  public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
    if (exception != null) {
      log.info("kinaction_error {}", exception.getMessage());
    } else {
      log.info("kinaction_info topic = {}, offset = {}", metadata.topic(), metadata.offset());
    }
  }

  @Override
  public void close() {

  }

  @Override
  public void configure(Map<String, ?> map) {

  }
}
