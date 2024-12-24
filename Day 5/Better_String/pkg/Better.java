package pkg;
public class Better {
    public String BetterString(String s1 , String s2){
        String s = "better";
        FunctionLambda l =()->{
            return s1.equals(s);
        };
        if (l.check() == true){
            return s1;
        }
        else{
        return s2;
        }
    }
    
}
