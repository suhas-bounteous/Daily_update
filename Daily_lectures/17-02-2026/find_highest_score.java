import java.util.*;

public class find_highest_score {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();
        
        while(true){
            System.out.println("Enter student score: ");
            int score = sc.nextInt();
            
            scores.add(score);
            
            System.out.println("Do you want to continue? (Y:N) ");
            char c = sc.next().charAt(0);
            
            if(c == 'N' || c == 'n'){
                break;
            }
        }
        
        if(scores.size() > 0){
            int highest = Collections.max(scores);
            System.out.println("Highest Score: " + highest);
        } else {
            System.out.println("No scores entered.");
        }
        
        sc.close();
    }
}
