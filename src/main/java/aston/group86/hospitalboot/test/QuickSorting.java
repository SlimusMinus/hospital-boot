package aston.group86.hospitalboot.test;

import java.util.Arrays;

public class QuickSorting {

  public static void main(String[] args) {
    int[] arr = new int[]{17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
    quickSort(arr, arr[0], arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }


  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        extracted(arr, i, j);
      }
    }

    extracted(arr, i + 1, high);

    return i + 1;
  }

  private static void extracted(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
