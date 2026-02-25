class DynamicArray_1<T>{
    private int size;
    private static final int max = 10;
    private Object[] data;

    public DynamicArray_1(){
        data = new Object[max];
        size = 0;
    }

    public void push(T val){
        ensureSize();
        data[size++] = val;
    }

    public void pop(){
        if(size==0){
            return;
        }
        data[size-1] = null;
        size--;
        return;
    }

    public T peek(){
        if(size==0){
            return null;
        }
        return (T) data[size-1];
    }

    public void ensureSize(){
        if(size == data.length){
            Object[] newdata = new Object[data.length*2];
            for(int i=0; i< data.length; i++){
                newdata[i] = data[i];
            }
            data=newdata;
        }
    }

    public int size(){
        return size;
    }
    public static void main(String[] args) {

        DynamicArray_1<String> list = new DynamicArray_1<>();

        list.push("Apple");
        list.push("Banana");
        list.push("Mango");

        System.out.println(list.peek());
        list.pop();
        System.out.println(list.peek());

        System.out.println(list.size());
    }
}