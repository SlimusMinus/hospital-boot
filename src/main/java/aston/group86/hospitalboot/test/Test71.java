package aston.group86.hospitalboot.test;

public class Test71 {
  public static void main(String[] args) {
    A a = new B();
  }
}

class A {
  private String a = "a";

  public A() {
    print();
  }

  public void print() {
    System.out.println(a.toUpperCase());
  }
}

class B extends A {
  private String b = "b";

  public B() {
    super();
  }

  @Override
  public void print() {
    System.out.println(b.toUpperCase());
  }
}

