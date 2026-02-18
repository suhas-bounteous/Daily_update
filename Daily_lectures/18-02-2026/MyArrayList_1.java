public class MyArrayList_1 {
    private Object[] elementData;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList_1() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object element) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = element;
    }

    private void grow() {
        int newCapacity = elementData.length * 2;
        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < elementData.length; i++) {
            newArray[i] = elementData[i];
        }
        elementData = newArray;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removedElement = elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return removedElement;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elementData[index];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

        MyArrayList_1 list = new MyArrayList_1();

        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        System.out.println(list.get(1));
        list.remove(0);

        System.out.println(list.get(1));

        System.out.println(list.size());
    }
}