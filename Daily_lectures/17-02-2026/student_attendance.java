import java.util.*;
public class student_attendance {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        boolean flag = true;
        while(flag){
            System.err.println("Enter the student name: ");
            String st = sc.nextLine();
            set.add(st);
            System.out.println("Do you want to continue(Y:N) ?");
            char c = sc.next().charAt(0);
            sc.nextLine();
            if(c == 'N' || c == 'n'){
                flag = false;
                break;
            }
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        sc.close();
    }
}
