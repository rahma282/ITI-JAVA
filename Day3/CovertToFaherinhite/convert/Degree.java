package convert;
import java.util.function.Function;
interface Convertion{
    default double ConvertTofahorheit (double celsius){
        double fahrenheit =((celsius*9)/5)+32; 
        return fahrenheit;
    }
}
/*
Function<T, R> is an in-built functional interface introduced in Java 8 in the java.util.function package.
The primary purpose for which Function<T, R> has been created is for mapping scenarios i.e when an object of a type is taken 
as input and it is converted(or mapped) to another type.Represents a function that accepts one
argument and produces a result.
Common usage of Function is in streams where-in the map function of a stream accepts an instance of Function to convert 
the stream of one type to a stream of another type
 */
public class Degree implements Function<Double, Double>,Convertion{
    @Override
    public Double apply(Double celsius) {
    double fahrenheit = ((celsius * 9) / 5) + 32;
        return fahrenheit;
    }
    /* 
    public static void main(String[] args) {
        System.out.println("Input celsius degree to convert to fahrenheit: ");
        try (Scanner scan = new Scanner (System.in)) {
            double celsius;
            celsius = scan.nextDouble();
            Degree convert = new Degree();
            System.out.println("Fahrenheit using Convertion interface: " + convert.ConvertTofahorheit(celsius));
            Degree converter = new Degree();
            System.out.println("Fahrenheit using Function<T, R> interface: " + converter.apply(celsius));
        }
    }*/
}
