package aston.group86.hospitalboot.test;

public class Test17 {

  public static void main(String[] args) {
    int a = 5;
    int b = 10;
    //поменять значения местами не вводя 3

    a = (a+b);
    b = (a-b);
    a = a-b;
    System.out.println(a + " " + b);
  }

}
