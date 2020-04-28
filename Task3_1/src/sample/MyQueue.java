package sample;

public class MyQueue {
    private float[] arr;
    private int head; // индекс первого элемента очереди
    private int tail; // индекс следующего за последним элементом очереди
    private int size;

    public MyQueue() {
        size = 0;
        head = 0;
        tail = 0;
        arr = new float[10];
    }

    public int getSize() {
        return size;
    }

    public float poll() throws Exception { // получить и удалить первый элемент очереди
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        float value = arr[head];
        arr[head] = 0;
        head++;
        size--;
        return value;
    }

    public void remove() throws Exception { // удалить первый элемент очереди
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        arr[head] = 0;
        head++;
        size--;
    }

    public void add(float value) { // добавляет элемент в очередь
        if (tail >= arr.length) {
            increaseArray((int) (size * 1.5));
            tail = size;
        }
        arr[tail] = value;
        tail++;
        size++;
    }

    public float peek() throws Exception { // возвращает первый элемент очереди
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return arr[head];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void increaseArray(int size) { // расширяет массив
        float[] newArr = new float[size];

        System.arraycopy(arr, head, newArr, 0, getSize());

        arr = newArr;
    }
}