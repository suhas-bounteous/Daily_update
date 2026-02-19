package Daily_update.DSA;

public class lenOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] st = s.split("\\W+");
        int n = st.length;
        String str = st[n-1];
        return str.length();
    }
    public static void main(String[] args) {
        String s = "Hello World";
        int n = lengthOfLastWord(s);
        System.out.println(n);
    }
}
