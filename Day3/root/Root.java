import java.util.Scanner;
import java.util.function.Function;

public class Root implements Function<double[], Double[]> {

    @Override
    public Double[] apply(double[] arr) {
        double equetion = Math.pow(arr[1], 2) - 4 * arr[0] * arr[2];  //b^2 - a * a *c
            if (equetion < 0) {
                System.out.println("The equation has no real roots (negative)");
                return null;
            }
            double sqrt = Math.sqrt(equetion);
            double root1 = (-arr[1] + sqrt) / (2 * arr[0]); 
            double root2 = (-arr[1] - sqrt) / (2 * arr[0]); 

        return new Double[]{root1, root2};
    }
  
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
