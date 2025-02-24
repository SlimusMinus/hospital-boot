package aston.group86.hospitalboot.test;

public class Test23 {

  //вам будет дана строка и два индекса (a и b).
// Ваша задача — перевернуть часть этой строки между этими двумя индексами включительно.
//Первый индекс a всегда будет меньше длины строки;
// второй индекс b может быть больше длины строки. Больше примеров в тестовых случаях. Удачи!
  public static void main(String[] args) {
    String word = "transactional";
    System.out.println(palindrom(word, 0, 25));

  }

  static String palindrom(String word, int a, int b) {

    if (b > word.length()) {
      b = word.length() - 1;
    }

    String subString = word.substring(a, b+1);
    String reverse = new StringBuilder(subString).reverse().toString();

    return word.replace(subString, reverse);
  }

}
