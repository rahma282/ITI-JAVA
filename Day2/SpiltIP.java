import java.util.Scanner;
import java.util.regex.Pattern;

public class SpiltIP {
    public static void main(String[] args) {
        String ip= "";
        ip = takeIp(ip);
        spilter(ip);

    }
    public static String takeIp(String ip){
        System.out.println("Enter an ip: ");
        Scanner scan = new Scanner(System.in);
        ip = scan.next();
        scan.close();
        return ip;
    }
    public static void spilter(String ip){
    if (validIp(ip)){
        String[] ips = ip.split("\\.");
        System.out.println("Ip after spilt: ");
        for (String c: ips){
            System.out.println(c);
        }
    }
    else {
        System.out.println("Invaild Ip..");
    }
        
    }
    public static boolean validIp(String ip) {

        String number = "(\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])";
        String ipRegex = number + "\\." + number + "\\." + number + "\\." + number;
        Pattern p = Pattern.compile(ipRegex);
        return p.matcher(ip).matches();
    }
}


