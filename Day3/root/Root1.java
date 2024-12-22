import calculateroot.Root;
import java.util.Scanner;
public class Root1{

    public static void main(String[] args) {
        try (Scanner scan = new Scanner (System.in)) {
            System.out.println("Input a,b,c: ");
            int size =3;
            double arr [] = new double [size];
            for (int i=0; i<size; i++){
                arr[i] = scan.nextDouble();
            }
        Root r = new Root();
        Double[] roots = r.apply(arr);

        if (roots != null) {
            System.out.println("Roots: " + roots[0] + ", " + roots[1]);
        }
        }

    }    
    }
