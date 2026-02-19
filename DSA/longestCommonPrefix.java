package Daily_update.DSA;

class longestCommonPrefix {
    public static String longest_Common_Prefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"India","Indigo","Indi","L","C","D","E"};
        String s = longest_Common_Prefix(strs);
        System.out.println(s);
        System.out.print("hello");
    }
}
