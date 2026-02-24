//Question 1
public class Generics<T> {
    private T values;

    public void set(T values){
        this.values = values;
    }

    public T get(){
        return values;
    }

    public static void main(String[] args) {
        Generics<String> stringGenerics = new Generics<>();
        stringGenerics.set("Hello Generics");
        System.out.println("String Value: " + stringGenerics.get());

        Generics<Integer> integerGenerics = new Generics<>();
        integerGenerics.set(123);
        System.out.println("Integer Value: " + integerGenerics.get());
    }
}
