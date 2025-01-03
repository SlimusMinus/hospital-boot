package aston.group86.hospitalboot.test;

public class Test22 {
  // проверить что строка является палиндром
  //    String palindrome = "madam,   I'm Adam";
  public static void main(String[] args) {

    String palindrome = "  madam,   I'm Adam";

    boolean result = true;
    int indexLeft = 0;
    int indexRight = palindrome.length()-1;

    while (indexLeft < indexRight){
      while (!Character.isAlphabetic(palindrome.charAt(indexLeft))){
        indexLeft++;
      }
      while(!Character.isAlphabetic(palindrome.charAt(indexRight))){
        indexRight--;
      }

      if(Character.toLowerCase(palindrome.charAt(indexLeft)) != Character.toLowerCase(palindrome.charAt(indexRight))){
        result = false;
        break;
      }
      indexLeft++;
      indexRight--;
    }
    System.out.println(result);
  }

}
