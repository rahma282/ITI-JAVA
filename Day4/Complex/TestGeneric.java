import complex.Complex;

public class TestGeneric {
    public static void main(String[] args) {
       
        Complex<Integer> complex1 = new Complex<>(3, 4);
        Complex<Integer> complex2 = new Complex<>(1, 2);

        System.out.println("Complex 1: " + complex1);
        System.out.println("Complex 2: " + complex2);

        Complex<Double> sum = complex1.add(complex2);
        System.out.println("Sum: " + sum);

        Complex<Double> difference = complex1.sub(complex2);
        System.out.println("Difference: " + difference);

        Complex<Integer> product = complex1.multiply(complex2);
        System.out.println("Product: " + product);
    }
}