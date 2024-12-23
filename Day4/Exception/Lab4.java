import exception.RException;
import exception.User;
import java.time.DateTimeException;
import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        User user = new User();
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter your name: ");
            String name = scan.nextLine();
            System.out.println("Enter your age: ");
            String age = scan.nextLine();
            System.out.println("Enter your date of birth: ");  //2002-02-08
            String date = scan.nextLine();
            
            System.out.println("date " + date);
            
            try {
                user.getUserName(name);
                user.getUserAge(age);
                user.getUserDateOfBirth(date);
            }
            catch (RException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            catch (DateTimeException e) {
                System.out.println(e.getMessage());
            }
            
            
        }
    }
}

