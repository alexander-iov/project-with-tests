package task7;

public class StackList implements IList, IStack {

    private final int[] numbers = new int[10];
    private int nextIndex = 0;

    @Override
    public void add(int i) {
        push(i);
    }

    @Override
    public void insert(int index, int value) {
        if (numbers.length - index + 1 >= 0) {
            System.arraycopy(numbers, index + 1 + 1, numbers, index + 1, numbers.length - index + 1);
        }
        numbers[index] = value;
    }

    @Override
    public void set(int index, int value) {
        numbers[index] = value;
    }

    @Override
    public int size() {
        return nextIndex;
    }

    @Override
    public int capacity() {
        return numbers.length;
    }

    @Override
    public int getByIndex(int index) {
        return numbers[index];
    }

    @Override
    public int getIndexByValue(int value) {
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean contains(int value) {
        boolean con = false;
        for (int num : numbers) {
            if (num == value) {
                con = true;
                break;
            }
        }
        return con;
    }

    @Override
    public void removeValue(int value) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                removeByIndex(i);
                break;
            }
        }
    }

    @Override
    public void removeByIndex(int index) {
        int[] temp = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numbers[index]) {
                continue;
            }
            temp[i] = numbers[i];
        }
        System.arraycopy(temp, 0, numbers, 0, temp.length);
        nextIndex--;
    }

    @Override
    public IList subList(int fromIndex, int toIndex) {
        IList newList = new StackList();
        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(numbers[i]);
        }
        return newList;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[10];
        System.arraycopy(numbers, 0, array, 0, numbers.length);
        return array;
    }

    @Override
    public void push(int value) {
        numbers[nextIndex] = value;
        nextIndex++;
    }

    @Override
    public int pop() {
        int value = numbers[nextIndex - 1];
        removeByIndex(nextIndex - 1);
        return value;
    }

    @Override
    public int peek() {
        return numbers[nextIndex];
    }
}


