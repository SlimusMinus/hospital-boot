package aston.group86.hospitalboot.test;

public class Test82 {

  static String nextColor = "yellow";

  public static void main(String[] args) {
    Thread red = new Thread(new Light("red"));
    Thread yellow = new Thread(new Light("yellow"));
    Thread green = new Thread(new Light("green"));

    red.start();
    yellow.start();
    green.start();
  }

  public static class Light implements Runnable {

    private final String color;
    private final String lock = "lock";

    public Light(String color) {
      this.color = color;
    }

    @Override
    public void run() {
      while (true) {
        try {
          Thread.sleep(1000);
          turnOn();
        } catch (InterruptedException e) {
          throw new RuntimeException();
        }
      }
    }

    private void turnOn() throws InterruptedException {
      synchronized (lock) {
        if (!color.equals(nextColor)) {
          lock.wait();
        }
        Thread.sleep(1000);
        System.out.println("Current color: " + color);
        lock.notifyAll();
      }

      nextColor = nextColor.equals("yellow") ? "green" : nextColor.equals("green") ? "red" : "yellow";
    }
  }

}
