package aston.group86.hospitalboot.KAFKA;


import org.apache.kafka.common.requests.TransactionResult;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.hibernate.Transaction;

public class KafStream {

  public static void main(String[] args) {
    StreamsBuilder streamsBuilder = new StreamsBuilder();
   /* KStream<String, Transaction> transactionStream = builder.stream("transaction-request", Consumed.with(stringSerde, transactionRequestAvroSerde));

    final KStream<String, TransactionResult> resultStream = transactionStream.transformValues( () -> new TransactionTransformer() );
    resultStream
        .filter(TransactionProcessor::success)
        .to(this.transactionSuccessTopicName,
            Produced.with(Serdes.String(), transactionResultAvroSerde));

    resultStream
        .filterNot(TransactionProcessor::success)
        .to(this.transactionFailedTopicName,
            Produced.with(Serdes.String(), transactionResultAvroSerde));

    KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), kaProperties);
    kafkaStreams.start();

    kafkaStreams.close();*/

  /*  KStream<String, Transaction> transactionStream =
        builder.stream("transaction-request",
            Consumed.with(stringSerde, transactionRequestAvroSerde));
    transactionStream.print(Printed.<String, Transaction>toSysOut()
        .withLabel("transactions logger"));
    KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), kaProperties);
    kafkaStreams.cleanUp();
    kafkaStreams.start();*/
  }

}
