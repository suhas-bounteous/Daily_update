class Main{
    static void main() {

        double totalAmount = orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();


    }

    public static int print(int a){
        System.out.println("Integer");
        return a;
    }

    public static String print(String a){
        System.out.println("String");
        return "String a";
    }
}
