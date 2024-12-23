import exception.RException;
import exception.User;
import java.time.DateTimeException;
import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        User user = new User();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your name: ");
            String name = scan.next();
            System.out.println("Enter your age: ");
            String age = scan.next();
            System.out.println("Enter your date of birth: ");
            String date = scan.next();
            try {
                user.getUserAge(age);
                user.getUserDateOfBirth(date);
                user.getUserName(name);
            }
            catch (RException e) {
                e.getMessage();
            }
            catch (DateTimeException e) {
                e.getMessage();
            }
            
            catch (Exception e) {
                e.getMessage();
            }
        }
    }
}

