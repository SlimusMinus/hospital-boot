package aston.group86.hospitalboot.kafka;


import static aston.group86.hospitalboot.datatest.DataTest.BROKER_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

import aston.group86.hospitalboot.KAFKA.Alert;
import aston.group86.hospitalboot.KAFKA.AlertKeySerde;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class KafkaTest {

  /*@ClassRule
  public static final EmbeddedKafkaCluster embeddedKafkaCluster = new EmbeddedKafkaCluster(BROKER_NUMBER);
  private Properties kaProducerProperties;
  private Properties kaConsumerProperties;

  @Before
  public void setUpBeforeClass() throws Exception {
    embeddedKafkaCluster.createTopic(TOPIC, PARTITION_NUMBER, REPLICATION_NUMBER);
    kaProducerProperties = TestUtils.producerConfig( embeddedKafkaCluster.bootstrapServers(), AlertKeySerde.class, StringSerializer.class);
    kaConsumerProperties = TestUtils.consumerConfig(embeddedKafkaCluster.bootstrapServers(), AlertKeySerde.class, StringDeserializer.class);
  }

  @Test
  public void testAlertPartitioner() throws InterruptedException {
    AlertProducer alertProducer = new AlertProducer();
    try {
      alertProducer.sendMessage(kaProducerProperties);
    } catch (Exception ex) {
      fail("kinaction_error EmbeddedKafkaCluster exception" + ex.getMessage());
    }
    AlertConsumer alertConsumer = new AlertConsumer();
    ConsumerRecords<Alert, String> records = alertConsumer.getAlertMessages(kaConsumerProperties);
    TopicPartition partition = new TopicPartition(TOPIC, 0);
    List<ConsumerRecord<Alert, String>> results = records.records(partition);
    assertEquals(0, results.get(0).partition());
  }*/
}
