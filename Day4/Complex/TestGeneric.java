import complex.Complex;

public class TestGeneric {
    public static void main(String[] args) {
       
        Complex<Integer> complex1 = new Complex<>(3, 4);
        Complex<Integer> complex2 = new Complex<>(1, 2);

        System.out.println("Complex 1: " + complex1);
        System.out.println("Complex 2: " + complex2);

        print();
        
        Complex<Double> sumDouble = complex1.add(complex2, Double.class); 
        Complex<Integer> sumInteger = complex1.add(complex2, Integer.class); 
        System.out.println("Sum Double: " + sumDouble);
        System.out.println("Sum Integer: " + sumInteger);

        print();

        Complex<Double> subDouble = complex1.sub(complex2, Double.class); 
        Complex<Integer> subInteger = complex1.sub(complex2, Integer.class); 
        System.out.println("Sub Double: " + subDouble);
        System.out.println("Sub Integer: " + subInteger);

        print();
        
        Complex<Integer> productInteger = complex1.multiply(complex2, Integer.class); 
        Complex<Double> ProductDouble = complex1.multiply(complex2, Double.class); 
        System.out.println("Product Integer: " + productInteger);
        System.out.println("Product Double: " + ProductDouble);
        print();
    }
    
    public static void print(){
        System.out.println("-----------------------------------------------");
    }
}