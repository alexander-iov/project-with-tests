package task7;

public class StackList implements IList, IStack{

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
    public Integer getIndexByValue(int value) {
        Integer index = 0;
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
        for (int num : numbers){
            if (num == value){
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
        nextIndex--;
    }

    @Override
    public void removeByIndex(int index) {
        if (numbers.length - index >= 0) {
            System.arraycopy(numbers, index + 1, numbers, index, numbers.length - index);
        }
    }

    @Override
    public IList subList(int fromIndex, int toIndex) {
        IList newList = new StackList();
        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(i);
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
        int value = numbers[nextIndex];
        removeByIndex(nextIndex);
        nextIndex--;
        return value;
    }

    @Override
    public int peek() {
        return numbers[nextIndex];
    }
}
