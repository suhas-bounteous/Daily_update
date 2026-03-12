package DAY1;
import java.util.Scanner;

class FactorialCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int factorial = 1;
        int i = 1;

        while (i <= num) {
            factorial = factorial * i;
            i++;
        }

        System.out.println("Factorial of " + num + " is " + factorial);

        sc.close();
    }
}
