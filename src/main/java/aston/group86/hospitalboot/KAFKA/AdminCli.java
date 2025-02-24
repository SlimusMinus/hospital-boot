package aston.group86.hospitalboot.KAFKA;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

public class AdminCli {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "localhost:9092, localhost:9093, localhost:9094");
    properties.put("acks", "all");
    properties.put("retries", "3");
    properties.put("max.in.flight.requests.per.connection", "1");
    properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    NewTopic newTopic = new NewTopic("kinaction_selfserviceTopic", 2, (short) 2);
    AdminClient adminClient = AdminClient.create(properties);
    CreateTopicsResult createTopicsResult = adminClient.createTopics(List.of(newTopic));
    createTopicsResult.values().get("kinaction_selfserviceTopic").get();
  }

}
