import java.util.Scanner;

class MissingNum {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n; 
        
        for (int i = 0; i < n; i++) {
            
            
            res ^= i ^ nums[i];
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array (0 to " + n + " with one missing):");
        for (int j = 0; j < n; j++) {
            nums[j] = sc.nextInt();
        }
        sc.close();
    }
}

