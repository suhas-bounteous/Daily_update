import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class num_of_prods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while(true){
            System.out.println("Enter the product name: ");
            String st = sc.nextLine();
            map.put(st, map.getOrDefault(st, 0)+1);
            System.out.println("Do you want to continue? (Y:N) ");
            char c= sc.next().charAt(0);
            sc.nextLine();
            if(c=='N' || c=='n'){
                break;
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        sc.close();

    }
}
