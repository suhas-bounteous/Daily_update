package DAY1;
import java.util.Scanner;

public class GradeCategorizer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter percentage: ");
        int percentage = sc.nextInt();

        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid input. Percentage must be between 0 and 100.");
        }
        else if (percentage >= 90) {
            System.out.println("Grade: A");
        }
        else if (percentage >= 80) {
            System.out.println("Grade: B");
        }
        else if (percentage >= 70) {
            System.out.println("Grade: C");
        }
        else if (percentage >= 60) {
            System.out.println("Grade: D");
        }
        else {
            System.out.println("Grade: F");
        }

        sc.close();
    }
}
