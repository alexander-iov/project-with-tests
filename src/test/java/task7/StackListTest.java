package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StackListTest {

    private StackList stackList;

    @BeforeEach
    public void init() {
        stackList = new StackList();
    }

    @Test
    public void isEmpty() {
        int actualSize = stackList.size();
        int expectedSize = 0;
        Assertions.assertEquals(actualSize, expectedSize);
    }

    @Test
    public void isIndexCorrect() {
        stackList.add(1);
        int actualIndex = stackList.getIndexByValue(1);
        int expectedIndex = 0;
        Assertions.assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void isIndexCorrectAfterDelete() {
        for (int i = 1; i <= 5; i++) {
            stackList.add(i);
        }
        stackList.removeValue(3);
        int actualIndex = stackList.getIndexByValue(4);
        int expectedIndex = 3;
        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void isCorrectException() throws ArrayIndexOutOfBoundsException {
        boolean actualResult = false;
        try {
            stackList.getByIndex(10);
        } catch (ArrayIndexOutOfBoundsException e) {
            actualResult = true;
        }
        Assertions.assertTrue(actualResult);
    }

    @Test
    public void isReturnList() {
        for (int i = 5; i >= 0; i--) {
            stackList.add(i);
        }
        IList list = stackList.subList(0, 2);
        int[] actualList = list.toArray();
        System.out.println(Arrays.toString(actualList));
        int[] expectedList = {5, 4, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertTrue(Arrays.equals(expectedList, actualList));
    }

    @Test
    public void isDeleteLastIndex() {
        for (int i = 5; i >= 0; i--) {
            stackList.add(i);
        }
        int actualResult = stackList.pop();
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void isAddInTheEnd() {
        for (int i = 5; i >= 0; i--) {
            stackList.add(i);
        }
        stackList.push(5);
        int expectedResult = 5;
        int actualResult = stackList.getByIndex(stackList.size() - 1);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
