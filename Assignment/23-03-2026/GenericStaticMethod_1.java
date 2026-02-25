//Question 2
class GenericStaticMethod_1<T> {

    public static <T extends Comparable<T>> T findMax(T a, T b, T c){
        if(a.compareTo(b)>0){
            if(a.compareTo(c)>0){
                return a;
            }else {
                return c;
            }
        }else if(b.compareTo(c)>0){
            return b;
        }else{
            return c;
        }
    }

    static void main() {
        GenericStaticMethod_1<Integer> sol1 = new GenericStaticMethod_1<>();
        int ans1 = sol1.findMax(12, 23, 34);
        System.out.println(ans1);

        GenericStaticMethod_1<Double> sol2 = new GenericStaticMethod_1<>();
        double ans2 = sol2.findMax(12.0, 23.89, 34.76);
        System.out.println(ans2);

        GenericStaticMethod_1<String> sol3 = new GenericStaticMethod_1<>();
        String ans3 = sol3.findMax("abc", "rat", "hat");
        System.out.println(ans3);
    }
}