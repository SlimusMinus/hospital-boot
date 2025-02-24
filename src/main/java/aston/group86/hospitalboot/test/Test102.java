package aston.group86.hospitalboot.test;

public class Test102 {

  public static void main(String[] args) {
    try {
      throw new IllegalArgumentException();
    } catch (IllegalArgumentException ex) {
      System.out.println("IllegalArgumentException");
      throw new IllegalStateException();
    } catch (IllegalStateException ex) {
      System.out.println("IllegalStateException");
    } finally {
      System.out.println("finally");
    }
  }

}
