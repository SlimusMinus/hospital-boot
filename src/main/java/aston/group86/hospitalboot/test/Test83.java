package aston.group86.hospitalboot.test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Напишите программу, которая реализует классический шаблон "Производитель-Потребитель" с
 * использованием многопоточности.
 * <p>
 * 1) Создайте общий буфер в виде очереди фиксированного размера (например, 5 элементов).
 * 2) Один поток должен выступать в роли производителя:
 * - Добавляет числа в очередь с интервалом 500 мс.
 * - Если очередь полная, ждет, пока освободится место.
 * 3) Второй поток должен выступать в роли потребителя:
 * - Удаляет числа из очереди с интервалом 1000 мс.
 * - Если очередь пустая, ждет, пока появятся элементы.
 * 4) Программа должна корректно завершаться после обработки 20 чисел.
 * <p>
 * Требования:
 * - Используйте synchronized и методы wait() / notify().
 * - Обеспечьте потокобезопасность и корректную работу с буфером.
 */
public class Test83 {

  public static void main(String[] args) {
    MyBuffer myBuffer = new MyBuffer(5);
    Thread threadConsumer = new Thread(new Consumer(myBuffer));
    Thread threadProducer = new Thread(new Producer(myBuffer));
    Thread threadProducer2 = new Thread(new Producer(myBuffer));
    Thread threadProducer3 = new Thread(new Producer(myBuffer));

    threadProducer.start();
    threadProducer2.start();
    threadProducer3.start();

    threadConsumer.start();
  }

}

class MyBuffer {

  private final int capacity;
  private final Queue<Integer> queue;

  public MyBuffer(int capacity) {
    this.capacity = capacity;
    this.queue = new ConcurrentLinkedQueue<>();
  }

  public void produce(int num) throws InterruptedException {
    while (queue.size() == capacity) {
      wait();
    }
    queue.add(num);
    System.out.println("Add element in queue " + num);
    System.out.println("Now length = " + queue.size());
    notifyAll();
  }

  public synchronized void consume() throws InterruptedException {
    while (queue.isEmpty()) {
      wait();
    }
    Integer poll = queue.poll();
    System.out.println("Element remove in queue " + poll);
    System.out.println("Now length = " + queue.size());
    notifyAll();
  }

}

record Producer(MyBuffer myBuffer) implements Runnable {

  @Override
  public void run() {
    try {
      for (int i = 0; i < 20; i++) {
        synchronized(myBuffer){
          myBuffer.produce(i);
          Thread.sleep(500);
        }
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

record Consumer(MyBuffer myBuffer) implements Runnable {

  @Override
  public void run() {
    try {
      while (true) {
        myBuffer.consume();
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}