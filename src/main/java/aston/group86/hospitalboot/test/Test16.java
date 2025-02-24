package aston.group86.hospitalboot.test;

public class Test16 {

  public static void main(String[] args) {
    // проверить что число является палиндромом
    int num = 121121;

    int reverse = 0;

    while (reverse < num) {
      int newNum = num % 10;
      reverse = reverse * 10 + newNum;
      num /= 10;
    }

    System.out.println(reverse == num || reverse/10 == num);
  }
}
