package DAY1;

import java.util.Scanner;

public class Fibonacci {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int prev2=0;
        int prev1=1;
        int i=2;
        int curr=0;
        while(i<n){
            curr = prev1+prev2;
            prev2=prev1;
            prev1=curr;
            i++;
        }
        System.out.println("Answer: "+curr);
        sc.close();
    }
}
