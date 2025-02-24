package aston.group86.hospitalboot.test;

public class Task47 {

  public static void main(String[] args) {
    String str = "Hello world";
    int count = 0;
    int iterator = str.length()-1;
    while (!String.valueOf(str.charAt(iterator)).equals(" ")){
      count++;
      iterator--;
    }
    System.out.println(count);
  }

}
