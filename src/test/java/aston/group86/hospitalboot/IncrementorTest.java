package aston.group86.hospitalboot;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class IncrementorTest {

  private static final int THREADS_COUNT = 3;
  private static final int INCREMENT_COUNT = 1000;

  private AtomicInteger counter = new AtomicInteger(0);

  @RepeatedTest(100)
  void incrementCounter() {
    final var threads = IntStream.range(0, THREADS_COUNT)
        .mapToObj(i -> {
          final var thread = new Thread(this::increment);
          thread.start();

          return thread;
        })
        .collect(Collectors.toList());

    for (var thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    Assertions.assertEquals(THREADS_COUNT * INCREMENT_COUNT, counter.get());
  }

  private void increment() {
    IntStream.range(0, INCREMENT_COUNT).forEach(i -> counter.incrementAndGet());
  }
}
