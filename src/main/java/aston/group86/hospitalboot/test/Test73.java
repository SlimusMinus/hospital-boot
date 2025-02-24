package aston.group86.hospitalboot.test;

public class Test73 {

  public static void main(String[] args) {
    String s = ("ЛллллююЮЮююббБбббЛЛлллююю теББяяя "
        + "ПеееетрррРРРаааАА ттттВВВооорреееНННньее").toLowerCase();
    //-> люблю тебя петра творенье

    StringBuilder words = new StringBuilder();
    words.append(s.charAt(0));

    for(int i = 1; i < s.length(); i++){
      if(s.charAt(i) != words.charAt(words.length()-1)){
        words.append(s.charAt(i));
      }
    }

    System.out.print(words);
  }
}
