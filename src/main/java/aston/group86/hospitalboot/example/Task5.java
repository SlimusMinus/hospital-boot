package aston.group86.hospitalboot.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Task5 {

  /*
 Задача:
 Есть несколько потоков-работников, которые параллельно увеличивают результат на 1.
 Главный поток должен дождаться, пока все они завершат свою работу,
 и затем главный поток использует результат их работы (выводит в консоль 5).
*/
  private static final int COUNT = 5;

  private static final AtomicInteger result =  new AtomicInteger(0);


  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(COUNT);
    CountDownLatch countDownLatch = new CountDownLatch(COUNT);

    List<Runnable> workerThreads = new ArrayList<>();
    for (int i = 0; i < COUNT; i++) {
          workerThreads.add(new Thread(() -> {

            try {
              Thread.sleep(500);
              System.out.println(Thread.currentThread().getName() + " started");
              result.getAndIncrement();
              Thread.sleep(1000);
              System.out.println(Thread.currentThread().getName() + " finished");
              countDownLatch.countDown();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }));

    }
    workerThreads.forEach(executor::submit);


    System.out.println(Thread.currentThread().getName() + " is waiting for others");
    countDownLatch.await();
    System.out.println(Thread.currentThread().getName() + " продолжил работу");

    System.out.println(result);

  }
}
