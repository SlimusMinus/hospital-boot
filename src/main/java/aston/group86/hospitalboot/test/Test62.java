package aston.group86.hospitalboot.test;




import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test62 {

  public static void main(String[] args) {
    System.out.println(getStr(1));
  }

  /*
   12 --> "10 + 2"
   45 --> "40 + 5"
   70304 --> "70000 + 300 + 4"
*/

  public static String getStr(int num) {

    String str = String.valueOf(num);

    return IntStream.range(0, str.length())
        .boxed()
        .filter(i -> str.charAt(i) != '0')
        .map(i -> new StringBuilder()
            .append(str.charAt(i))
            .append("0".repeat(str.length() - 1 - i)))
        .collect(Collectors.joining(" + "));
  }
}
