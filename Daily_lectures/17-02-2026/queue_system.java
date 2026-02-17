import java.util.*;
public class queue_system {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new ArrayDeque<>();

        while(true){
            System.out.println("Enter patient name: ");
            String st = sc.nextLine();
            q.add(st);
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        for (String item : q) {
            System.out.println(item);
        }
        
        sc.close();
    }
}
