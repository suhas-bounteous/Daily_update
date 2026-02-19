package Daily_update.DSA;

public class countBinarySubstring {
    public static int count_Binary_Substrings(String s) {
        int res = 0, prev = 0, strk = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                strk++;
            } else {
                prev = strk;
                strk = 1;
            }

            if (strk <= prev) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String input1 = "00110011";
        String input2 = "10101";
        String input3 = "000111000";

        System.out.println("Input: " + input1);
        System.out.println("Output: " + count_Binary_Substrings(input1));

        System.out.println("\nInput: " + input2);
        System.out.println("Output: " + count_Binary_Substrings(input2));

        System.out.println("\nInput: " + input3);
        System.out.println("Output: " + count_Binary_Substrings(input3));
    }

}
