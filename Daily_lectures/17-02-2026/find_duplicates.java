import java.util.*;

public class find_duplicates {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        while(true){
            System.out.println("Enter a number: ");
            int num = sc.nextInt();
            
            numbers.add(num);
            
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        for(Integer n : numbers){
            if(!seen.add(n)){
                duplicates.add(n);
            }
        }
        
        System.out.println("Duplicates:");
        for(Integer d : duplicates){
            System.out.print(d + " ");
        }
        
        sc.close();
    }
}
