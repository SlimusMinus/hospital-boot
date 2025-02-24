package aston.group86.hospitalboot.test;


/*Напишите программу, которая имитирует работу многозадачной системы.
Программа должна создавать несколько потоков, каждый из которых выполняет задачу, связанную с подсчётом чисел в определённом диапазоне.
    Условия:

Программа должна создавать n потоков (где n — количество потоков, передаваемое как параметр).
Каждый поток должен подсчитывать сумму чисел в своём диапазоне от start до end (диапазон делится между потоками поровну).
    После того, как все потоки завершат выполнение, программа должна вывести общую сумму чисел.
Задача должна быть выполнена с использованием механизма синхронизации потоков, чтобы избежать проблем с доступом к общим данным.

Технические требования:

Используйте интерфейс Runnable для создания потоков.
Для синхронизации работы потоков можно использовать класс CountDownLatch или другие механизмы синхронизации.
Необходимо корректно обрабатывать возможные ошибки и исключения.
Программа должна быть выполнена с использованием стандартных библиотек Java.*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Test87 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println(getSum2(1, 10, 4));
  }

  public static int getSum2(int start, int end, int countThread) throws InterruptedException {

    CountDownLatch latch = new CountDownLatch(countThread);

    int rangePerThread = (end - start + 1) / countThread;

    int[] array = new int[countThread];

    for (int i = 0; i < countThread; i++) {

      int threadIndex = i;

      int threadStart = start + threadIndex * rangePerThread;
      int threadEnd = (threadIndex == countThread - 1) ? end : (threadStart + rangePerThread - 1);

      new Thread(() -> {
        int sum = 0;
        for (int j = threadStart; j <= threadEnd; j++) {
          sum += j;
        }
        array[threadIndex] = sum;

        latch.countDown();

      }).start();
    }

    latch.await();

    int result = 0;

    for (int sum : array) {
      result += sum;
    }

    return result;

  }


  public static int getSum(int start, int end, int countThread)
      throws ExecutionException, InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(countThread);

    int rangePerThread = (end - start + 1) / countThread;

    List<Future<Integer>> list = new ArrayList<>();

    for (int i = 0; i < countThread; i++) {
      int threadStart = start + i * rangePerThread;
      int threadEnd = (i == countThread - 1) ? end : (threadStart + rangePerThread - 1);

      Future<Integer> submit = executorService.submit(() -> {
        int sum = 0;
        for (int j = threadStart; j <= threadEnd; j++) {
          sum += j;
        }
        return sum;
      });
      list.add(submit);
    }

    int finisSum = 0;

    for (Future<Integer> item : list) {
      finisSum += item.get();
    }

    executorService.shutdown();

    return finisSum;

  }

}
