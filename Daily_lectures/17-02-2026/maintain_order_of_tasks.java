import java.util.ArrayList;
import java.util.Scanner;

public class maintain_order_of_tasks {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        
        while(true){
            System.out.println("Enter a task: ");
            String task = sc.nextLine();
            
            tasks.add(task);   
            
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            sc.nextLine();  
            
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        System.out.println("Tasks in insertion order:");
        for(String t : tasks){
            System.out.println(t);
        }
        
        sc.close();
    }
}
