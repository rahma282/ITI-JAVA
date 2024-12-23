package exception;
import java.time.DateTimeException;

public class User {
public int getUserAge(String age) throws NumberFormatException{
    int ageInt = Integer.parseInt(age);
    if (ageInt <= 0) {
        throw new NumberFormatException("Error: Negative number, please input a positive number");
    }

    return ageInt;
}
public String getUserDateOfBirth(String date) throws DateTimeException {
        if (date.matches("^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$")) {
            return date;
        } else {
            throw new DateTimeException("Error: Not a valid date, please input a valid date");
        }
    }
public String getUserName(String name) throws RException {
    if (name.matches("^([A-Za-z][a-z]+)( [A-Za-z][a-z]+)+$")) {
        return name;
    } else {
        throw new RException("Error: Not a valid name, please input a valid first name ,last name");
    }
}
}
