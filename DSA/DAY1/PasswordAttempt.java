package DAY1;

import java.util.Scanner;

public class PasswordAttempt {
    static void main() {
        String password = "HeyItsMe";
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("Enter the passowrd: ");
            String input = sc.nextLine();
            if(input.equals(password)){
                System.out.println("Access Granted");
                flag = false;
            } else {
                System.out.println("Access Denied");
            }
        }while(flag);
        sc.close();
    }
}
