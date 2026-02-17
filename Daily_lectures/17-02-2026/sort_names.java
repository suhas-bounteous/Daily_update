import java.util.*;

public class sort_names {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        
        while(true){
            System.out.println("Enter student name: ");
            String name = sc.nextLine();
            
            names.add(name);
            
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            sc.nextLine(); 
            
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        Collections.sort(names);
        
        System.out.println("Names in alphabetical order:");
        for(String n : names){
            System.out.println(n);
        }
        
        sc.close();
    }
}
