package DAY1;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int s = (int)Math.sqrt(n);

        boolean isPrime = true;

        for(int i = 2; i <= s; i++){
            if(n % i == 0){
                isPrime = false;
                break;
            }
        }

        if(isPrime && n > 1){
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
        sc.close();
    }
}
