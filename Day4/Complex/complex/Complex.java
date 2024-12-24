package complex;


public class Complex<T extends Number> {
    T real;
    T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
    }

    public <U extends Number> Complex<U> add(Complex<? extends Number> c, Class<U> cl) {
    //doubleValue() -->necessary because arithmetic operations like addition are generally performed using primitive double
        double realSum = real.doubleValue() + c.real.doubleValue();  
        double imgSum = img.doubleValue() + c.img.doubleValue();
        return castComplex((U) Double.valueOf(realSum), (U) Double.valueOf(imgSum), cl);
    }

    public <U extends Number> Complex<U> sub(Complex<? extends Number> c, Class<U> cl) {
        double realSub = real.doubleValue() - c.real.doubleValue();
        double imgSub = img.doubleValue() - c.img.doubleValue();
        return castComplex((U) Double.valueOf(realSub), (U) Double.valueOf(imgSub), cl);
    }

    public <U extends Number> Complex<U> multiply(Complex<? extends Number> c, Class<U> cl) {
        double realMultiply = real.doubleValue() * c.real.doubleValue();
        double imgMultiply = img.doubleValue() * c.img.doubleValue();
        return castComplex((U) Double.valueOf(realMultiply), (U) Double.valueOf(imgMultiply), cl);
    }

    
    @Override
    public String toString (){
        return real + "+" + img + "i";
    }
    private <U extends Number> Complex<U> castComplex(U real, U img, Class<U> cl) {
        if (cl == Double.class) {
            return new Complex<U>((U) Double.valueOf(real.doubleValue()), (U) Double.valueOf(img.doubleValue()));
        } else if (cl == Integer.class) {
            return new Complex<U>((U) Integer.valueOf(real.intValue()), (U) Integer.valueOf(img.intValue()));
        } else {
            throw new UnsupportedOperationException("Unsupported type");
        }
    }
}
/*
Double.class refers to the Class object associated with the Double class.
This is part of Java's reflection mechanism
which allows you to inspect classes and objects at runtime
Double.class in Java is a way to refer to the Double class itself, which is used to represent decimal numbers
Reflection: It helps you inspect the Double class or work with it dynamically.
Type checking: You can compare types using Double.class
Reflection in Java is a powerful feature that allows you to inspect and manipulate classes, methods, fields, and other components of a Java program at runtime (when the program is running) instead of compile-time
the Class -->  cls is an object that represents the<U> --> Double or Integer Class, through this object -> I'm able to attain information about these classes itself. 
//Class<U> cl: This is a Class object that represents the class type U. It is used to get information about the U type and is essential for type casting in this method.
*/
