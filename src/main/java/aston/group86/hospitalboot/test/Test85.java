package aston.group86.hospitalboot.test;

import java.util.concurrent.CopyOnWriteArrayList;

public class Test85 {

  public static void main(String[] args) throws InterruptedException {
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    Foo foo = new Foo(list);

    var third = new Thread(() -> {
      foo.third();
    });

    var second = new Thread(() -> {
      try {
        third.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      foo.second();
    });

    var first = new Thread(() -> {
      try {
        second.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      foo.first();
    });


    third.start();
    second.start();
    first.start();

    third.join();
    second.join();
    first.join();

    // [third, second, first]
    System.out.println(list);
  }
}

class Foo {

  final CopyOnWriteArrayList<String> outList;

  public Foo(CopyOnWriteArrayList<String> outList) {
    this.outList = outList;
  }

  void first() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    outList.add("first");
  }

  void second() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    outList.add("second");
  }

  void third() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    outList.add("third");
  }
}