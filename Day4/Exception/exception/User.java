package exception;

import java.time.DateTimeException;

public class User {
public String getUserAge(String age) throws Exception{
    for (int i = 0; i < age.length(); i++) {
        if (!Character.isDigit(age.charAt(i))) {
            throw new RException("Error : Not a number, please input a vaild age");
        }
        else {
            if ( Integer.parseInt(age) <0){
                throw new Exception("Error : nagative number, please input a positive number");
            }
        }
    }
    return age;
}
public String getUserDateOfBirth(String date) throws DateTimeException{

    if (date.matches("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$")) {
        return date;
    } else 
        throw new DateTimeException("Error : Not a date, please input a vaild date");
}
public String getUserName(String name) throws RException{
    if (name.matches("^([A-Z][a-z]+)( [A-Z][a-z]+)+$")){
        return name;
    }
    else{
        throw new RException("Error : Not a name, please input a vaild name");
    }
   
}
}
