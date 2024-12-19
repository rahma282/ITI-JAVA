
import java.util.Arrays;
import java.util.Scanner;


public class Min_Max {
  public static void main(String[] args) {
    int array []= {2,6,7,0,8,9,10,1,3,4,5};
    Arrays.sort(array);
    System.out.println(Arrays.toString(array));
    linearSearch(array);
    binarySearch(array);
  }
    /*
     * case 1 develop an application that extracts the minimum and maximum of the
     * elements
     * of an array of (1000) elements and compute the search running time.
     */
  public static void linearSearch(int [] array){
    long before = System.nanoTime();

    int min = array[array.length-1];
    int max = array[0];
    int max3 = array[0];

    for (int i = 0; i < array.length; i++) {

      if (max < array[i]) {
        max3= max-1;
        max = array[i];
      }
      if (min > array[i]) {
        min = array[i];
      }
    }
    System.out.println(" The minimum element in the array is :" + min);
    System.out.println(" The maximum element in the array is :" + max);
    System.out.println(" The Third maximum element in the array is :" + max3);
    long after = System.nanoTime();
    System.out.println("Search running time in nanoseconds before the array process " + before + "-" + " time in nanoseconds after the array process "+ after + " = "+ (after - before));
  
    }
      /*
     * case 2 rewrite application to implement the binary search algorithm and
     * compete the running time.
  */
  public static void binarySearch(int [] myArray){
    long before = System.nanoTime();
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter a random number maximum 10:");
    int random = scan.nextInt();

    int first = 0;
    int last = myArray.length - 1;
    int mid = (first + last) / 2;
    // binary search algorithm
    while (first <= last) {
      if (myArray[mid] < random)
        first = mid + 1;
      else if (myArray[mid] == random) {
        System.out.println(random + " found at location " + (mid + 1) + ".");
        break;
      } else {
        last = mid - 1;
      }
      mid = (first + last) / 2;
    }
    if (first > last)
      System.out.println(random + " is not found.\n");

    long after = System.nanoTime();
    System.out.println("Search running time in nanoseconds before the array process " + before + " - " + " time in nanoseconds after binary search algorithm process "+ after + " = "+ (after - before));

    scan.close();
}
}






