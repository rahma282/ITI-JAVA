import java.util.Scanner;
import convert.Degree;
class test{
public static void main(String[] args) {
        System.out.println("Input celsius degree to convert to fahrenheit: ");
        try (Scanner scan = new Scanner (System.in)) {
            double celsius;
            celsius = scan.nextDouble();
            Degree converter = new Degree();
            System.out.println("Fahrenheit using Function<T, R> interface: " + converter.apply(celsius));
        }
    }
}
