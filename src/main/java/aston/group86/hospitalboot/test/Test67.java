package aston.group86.hospitalboot.test;

public class Test67 {

  //Дан бассейн со столбами разного размера нужно
  //посчитать максимальную площадь по высоте столбов
  public static void main(String[] args) {
    int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(arr));
  }

  public static int maxArea(int[] height) {
    int max = 0;
    int current;

    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int min = Math.min(height[i], height[j]);
        current = min * (j - i);
        if (current > max) {
          max = current;
        }
      }
    }
    return max;
  }
}