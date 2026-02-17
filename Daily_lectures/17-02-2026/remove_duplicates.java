import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class remove_duplicates {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new LinkedHashSet<>();
        
        while(true){
            System.out.println("Enter a number: ");
            int num = sc.nextInt();
            
            set.add(num);
            
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        System.out.println("After removing duplicates:");
        for(Integer n : set){
            System.out.print(n + " ");
        }
        
        sc.close();
    }
}
