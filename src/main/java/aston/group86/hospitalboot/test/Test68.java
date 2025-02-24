package aston.group86.hospitalboot.test;

public class Test68 {

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
  }

  public static String longestPalindrome(String s) {
    int rightIndex = s.length();
    for(int i = 0; i < s.length(); i++){
      if(isPalindrom(s.substring(i, rightIndex))){
        return s.substring(i, rightIndex);
      }
      rightIndex--;
    }
    return null;
  }

  public static boolean isPalindrom(String s){

    String reversed = new StringBuilder(s).reverse().toString();
    return s.equalsIgnoreCase(reversed);

   /* String first = s.substring(0, s.length()/2+1);
    String second = s.substring(s.length()/2, s.length());

    StringBuilder stringBuilder = new StringBuilder(second).reverse();
    return first.contentEquals(stringBuilder);*/
  }

}
