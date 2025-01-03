package aston.group86.hospitalboot.KAFKA;


import java.nio.charset.StandardCharsets;
import org.apache.kafka.common.serialization.Serializer;

public class AlertKeySerde implements Serializer<Alert> {

  @Override
  public byte[] serialize(String topic, Alert key) {
    if (key == null) {
      return null;
    }
    return key.getStageId().getBytes(StandardCharsets.UTF_8);
  }
}
