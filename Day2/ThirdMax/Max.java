public class Max {
    public static void main (String args[]){
        int arr [] = {11,33,9,0,3,5,6}; //0 3 5 6 9 11 33
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

        if (max < arr[i]) {
            max3=max2;
            max2= max;
            max = arr[i];
        }
        else if (arr[i]>max2){
            max3=max2;
            max2=arr[i];
        }
        else if (arr[i]> max3){
            max3= arr[i];
        }
        }
        System.out.println(" The maximum element in the array is :" + max);
        System.out.println(" The Third maximum element in the array is :" + max3);
    }
}