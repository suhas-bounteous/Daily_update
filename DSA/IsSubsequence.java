
public class IsSubsequence {
    public static boolean check(String s, String t) {
        int a = 0;
        char[] tc = s.toCharArray();
        int sc= s.length();
        if(sc==0) return true;
        if(t.length()==0) return false;
        for(char ch: t.toCharArray()){
            if(tc[a]==ch){
                a++;
            }
            if(a==sc){
                break;
            }
        }
        if(a==sc){
            return true;
        }
        return false;
    }

    static void main() {
        String s="abc";
        String t="afbdc";
        boolean flag = check(s, t);
        System.out.printf("The sequence is: "+flag);
    }
}
