package aston.group86.hospitalboot.test;

public class Test84 {
  private static int counter = 0;


  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(Test84::incrementCounter);
    Thread thread2 = new Thread(Test84::incrementCounter);
    Thread thread3 = new Thread(Test84::incrementCounter);

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();

    System.out.println("Value of counter: " + counter);
  }

  private static void incrementCounter() {
   String lock = "lock";
    for (int i = 0; i < 1000000; i++) {
      synchronized (lock){
        counter++;
      }
    }
  }
}
