package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackListTest {

    private StackList stackList;

    @BeforeEach
    public void init(){
        stackList = new StackList();
    }

    @Test
    public void isEmpty(){
        int actualSize = stackList.size();
        int expectedSize = 0;
        Assertions.assertEquals(actualSize, expectedSize);
    }

    @Test
    public void isIndexCorrect(){
        stackList.add(1);
        int actualIndex = stackList.getIndexByValue(1);
        int expectedIndex = 0;
        Assertions.assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void isIndexCorrectAfterDelete(){
        for (int i = 1; i <=5; i++){
            stackList.add(i);
        }
        stackList.removeValue(3);
        int actualIndex = stackList.getIndexByValue(4);
        int expectedIndex = 3;
        Assertions.assertEquals(expectedIndex, actualIndex);
    }
}
