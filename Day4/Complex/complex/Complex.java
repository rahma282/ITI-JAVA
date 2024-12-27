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
Complex<? extends Number> means that the argument can be a Complex object containing any subtype of Number.
<U extends Number> indicates that the return type of the method is a Complex<U>, where U is a subclass of Number (e.g., Double or Integer).
The extends Number part restricts the type U to only be numeric types (or subclasses of Number). This is useful because the methods (add, sub, multiply) need to perform arithmetic operations on numbers, and Number provides common methods like doubleValue() and intValue() for that purpose.
It is used to define generic methods that operate on complex numbers and return results of a certain numeric type. For example, in the add, sub, and multiply methods, the type U is used to define the return type of the method, which will be a Complex<U>, where U is determined at runtime.
Complex<U> is the type of a complex number where both the real and imaginary parts are of type U.
<U extends Number> defines the type parameter for generics, indicating that the type U must be a subclass of Number.
Complex<U> defines a generic class where U specifies the type of the real and imaginary parts of a complex number.
*/
