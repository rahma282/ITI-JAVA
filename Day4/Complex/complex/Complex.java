package complex;


public class Complex<T extends Number> {
    T real;
    T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
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

    public <U extends Number> Complex<U> add(Complex<? extends Number> c, Class<U> cl) {
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
}
