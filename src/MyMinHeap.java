public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void insert(T item) {
        list.add(item);
        heapifyUp(list.size() - 1);
    }

    public T getMin() {
        return list.get(0);
    }

    public T extractMin() {
        T min = list.get(0);
        list.set(0, list.getLast());
        list.removeLast();
        heapifyDown(0);
        return min;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parent)) < 0) {
                T temp = list.get(index);
                list.set(index, list.get(parent));
                list.set(parent, temp);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        while (index < list.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0)
                smallest = left;
            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0)
                smallest = right;
            if (smallest != index) {
                T temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                index = smallest;
            } else break;
        }
    }
}
