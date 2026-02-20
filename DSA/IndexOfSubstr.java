package Daily_update.DSA;
class IndexOfSubstr {
    public static int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.
                    indexOf(needle);
        }else{
            return -1;
        }
    }

    static void main() {
        String h = "BounteousxAccolite";
        String n = "Accolite";
        int res = strStr(h,n);
        System.out.println(res);
    }
}