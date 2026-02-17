import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class store_emp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        while(true){
            System.out.println("Enter emp id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter emp name: ");
            String name = sc.nextLine();
            
            map.put(id, name);
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            sc.nextLine();  
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        System.out.println("Emp details:");
        for(Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        sc.close();
    }
}
