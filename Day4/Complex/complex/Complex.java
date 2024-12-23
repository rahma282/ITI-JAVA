package complex;


public class Complex<T extends Number> {
    T real;
    T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
    }

    public Complex<Double>add (Complex<T> c){
        return new Complex<> (real.doubleValue () + c.real.doubleValue (),img.doubleValue () + c.img.doubleValue ());
    }
    
    public Complex<Double> sub (Complex<T> c1){
        return new Complex<>(real.doubleValue()- c1.real.doubleValue(), img.doubleValue() - c1.img.doubleValue());
    }
    public Complex<Integer> multiply (Complex<T> c1){
        return new Complex<>(real.intValue() * c1.real.intValue(), img.intValue() * c1.img.intValue());
    }
    @Override
    public String toString (){
        return real + "+" + img + "i";
    }
}
