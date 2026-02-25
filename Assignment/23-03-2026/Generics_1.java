//Question 1
public class Generics_1<T> {
    private T values;

    public void set(T values){
        this.values = values;
    }

    public T get(){
        return values;
    }

    public static void main(String[] args) {
        Generics_1<String> stringGenerics1 = new Generics_1<>();
        stringGenerics1.set("Hello Generics_1");
        System.out.println("String Value: " + stringGenerics1.get());

        Generics_1<Integer> integerGenerics1 = new Generics_1<>();
        integerGenerics1.set(123);
        System.out.println("Integer Value: " + integerGenerics1.get());
    }
}
