package aston.group86.hospitalboot.KAFKA;


import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.Topology;

public class Topolog {
  public static void main(String[] args) throws Exception {

    final Serde<String> stringSerde = Serdes.String();
    Deserializer<String> stringDeserializer = stringSerde.deserializer();
    Serializer<String> stringSerializer = stringSerde.serializer();
    Topology topology = new Topology();
/*    topology = topology.addSource(LATEST,
        "kinaction_source",
        stringDeserializer,
        stringDeserializer,
        "kinaction_source_topic");*/
  }

}
