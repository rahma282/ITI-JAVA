package complex;


public class Complex<T extends Number> {
    T real;
    T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
    }

    public <U extends Number> Complex<U> add(Complex<? extends Number> c, Class<U> cl) {  //Class<U> cl objectparameter is used to determine the result type of the operation. This allows the method to return a Complex<U> object, where U can be either Double or Integer
        double realSum = real.doubleValue() + c.real.doubleValue();
        double imgSum = img.doubleValue() + c.img.doubleValue();
        //Type Checking: Depending on whether cl is Double.class or Integer.class,
        // it creates a new Complex<U> with the appropriate type (Double or Integer)
        if (cl == Double.class) {
            return new Complex<U>((U) Double.valueOf(realSum), (U) Double.valueOf(imgSum));
        } else if (cl == Integer.class) {
            return new Complex<U>((U) Integer.valueOf((int) realSum), (U) Integer.valueOf((int) imgSum));
        } else {
            throw new UnsupportedOperationException("Unsupported type");
        }
    }
    
    public <U extends Number> Complex<U> sub (Complex<? extends Number> c, Class<U> cl){
        double realSub = real.doubleValue() - c.real.doubleValue();
        double imgSub = img.doubleValue() - c.img.doubleValue();
        if (cl == Double.class) {
            return new Complex<U>((U) Double.valueOf(realSub), (U) Double.valueOf(imgSub));
        } else if (cl == Integer.class) {
            return new Complex<U>((U) Integer.valueOf((int) realSub), (U) Integer.valueOf((int) imgSub));
        } else {
            throw new UnsupportedOperationException("Unsupported type");
        }
    }
    public <U extends Number> Complex<U> multiply (Complex<? extends Number> c, Class<U> cl){
        double realMultiply = real.doubleValue() * c.real.doubleValue();
        double imgMultiply = img.doubleValue() * c.img.doubleValue();
        if (cl == Double.class) {
            return new Complex<U>((U) Double.valueOf(realMultiply), (U) Double.valueOf(imgMultiply));
        } else if (cl == Integer.class) {
            return new Complex<U>((U) Integer.valueOf((int) realMultiply), (U) Integer.valueOf((int) imgMultiply));
        } else {
            throw new UnsupportedOperationException("Unsupported type");
        }
    }
    @Override
    public String toString (){
        return real + "+" + img + "i";
    }
}
