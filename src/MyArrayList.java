public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;


    public MyArrayList(){
        data = new Object[10];
        size = 0;
    }
    private void grow() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public void add(T item) {
        if (size == data.length) grow();
        data[size] = item;
        size++;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void addLast(T item) {
        add(item);
    }
    @Override
    public void addFirst( T item){
        if(size== data.length) grow();
        for (int i = size; i> 0;i--){
            data[i]= data[i-1];

    }
        data[0]= item;
        size++;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
        return (T) data[index];
    }
    @Override
    public void set(int index,T item){
    if(index<0 || index>= size)
    throw new IndexOutOfBoundsException("index:" + index);
        data[index] = item;
    }
    @Override
    public T getFirst() {
        return get(0);  }

    @Override
    public T getLast() {
        return get(size-1);
    }
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }
    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object))
                return i;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if(data[i].equals(object))
                return i;
        }
        return -1;
    }
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = data[i];
        return result;
    }
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        if (size == data.length) grow();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) data[j]).compareTo((T) data[j + 1]) > 0) {
                    Object temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return (T) data[cursor++];
            }
        };
    }


}
