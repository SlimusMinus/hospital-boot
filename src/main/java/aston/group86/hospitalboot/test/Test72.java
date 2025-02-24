package aston.group86.hospitalboot.test;

public class Test72 {
    static int i;
    public static void main(String[] args) throws Exception {


      Thread thread1 = new Thread(() -> increment());
      Thread thread2 = new Thread(() -> increment());

      thread1.start();
      thread2.start();

      thread1.join();
      thread2.join();

      System.out.println(i);
    }

    static void increment() {
      for (int j = 0; j < 100_000_000L; j++) {
        i++;
      }
    }

}
