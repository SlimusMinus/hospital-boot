package aston.group86.hospitalboot.test2.overLoad;

import java.io.IOException;

public class Dotcher extends OverLoad{

  @Override
  public Integer sum(int a, int b) throws IOException, RuntimeException {
    return 2;
  }

  static byte a = 40;
  static byte b = 50;


  public static void main(String[] args) {
    byte c = (byte) (a+b);
    System.out.println(c);
  }
}
