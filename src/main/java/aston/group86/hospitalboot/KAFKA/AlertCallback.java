package aston.group86.hospitalboot.KAFKA;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

@Slf4j
public class AlertCallback implements Callback {
  public void onCompletion(RecordMetadata recordMetadata, Exception e){
    if(e != null){
      log.error("kinaction_error", e);
    } else {
      log.info("kinaction_info offset = {}, topic = {}, timestamp = {}",
          recordMetadata.offset(), recordMetadata.topic(), recordMetadata.timestamp());
    }
  }
}
