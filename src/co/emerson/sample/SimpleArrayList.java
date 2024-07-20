package co.emerson.sample;

import java.util.Arrays;

public class SimpleArrayList {

    private Object[] elements;
    private int size = 0;

    public SimpleArrayList() {
        elements = new Object[10];
    }

    public void add(Object element){
        if (size == elements.length){
            elements = Arrays.copyOf(elements,2 * size);
        }
        elements[size] = element;
        size++;
    }

    public Object get(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index: "+ index + ", Size: "+ size);
        }
        return elements[index];
    }

    public int size(){
        return size;
    }

}
