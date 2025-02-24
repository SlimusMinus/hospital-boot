package aston.group86.hospitalboot.test;


public class Test61 {

  public static void main(String[] args) {
    System.out.println(getNum(new int[]{4, 2, 3}));
  }

  /*
    Дана упорядоченная последовательность чисел от 1 до N.
    Одно из чисел удалили. Оставшиеся перемешали в случайном порядке.
    Найти удалённое число
     */
  public static int getNum(int[] array) {
    //4,1,2
    //(1+4)/2*4
    int num = array.length;
    int sum = (1 + num + 1) * (num + 1) / 2;

    for (int j : array) {
      sum -= j;
    }
    return sum;
  }

}
