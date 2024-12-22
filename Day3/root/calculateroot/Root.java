package calculateroot;
import java.util.function.Function;

public class Root implements Function<double[], Double[]> {  //ax² + bx + c = 0
    //<double[]  -->  a ,b ,c, Double[] --> root1, root2
    @Override
public Double[] apply(double[] arr) {
    double equetion = calculateEqueation(arr);
    if (isNegative(equetion)) {
        System.out.println("The equation has no real roots (negative equetion)");
        return null;
    }

    return calculateRoots(arr, equetion);
}


private double calculateEqueation(double[] arr) {
    return Math.pow(arr[1], 2) - 4 * arr[0] * arr[2]; // b^2 - 4ac
}

private Double[] calculateRoots(double[] arr, double equation) {
    double sqrt = Math.sqrt(equation); 
    double root1 = calcNegativeRoot(arr, sqrt);
    double root2 = calcPosRoot(arr, sqrt);
    return new Double[]{root1, root2};
}


private boolean isNegative(double x) {
    return x < 0;
}
private double calcPosRoot(double[] arr, double sqrt){
    return (-arr[1] + sqrt) / (2 * arr[0]);
}
private double calcNegativeRoot(double[] arr, double sqrt) {
    return (-arr[1] - sqrt) / (2 * arr[0]);
}

  
}
