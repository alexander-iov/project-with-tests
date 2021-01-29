package task13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocalDateWorkingTest {

    private LocalDateWorking localDateWorking;

    @BeforeEach
    public void init(){
        localDateWorking = new LocalDateWorking();
    }

    @Test
    public void testValidReturnOfFormatting(){
        String actualResult = localDateWorking.formatting();
        String expectedResult = "19:32 2021/01/29";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidReturnOfParsing(){
        String actualResult = localDateWorking.parsing().toString();
        String expectedResult = "1999-06-18T19:34:55";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidReturnOfLessonDuration(){
        String actualResult = localDateWorking.lessonDuration();
        String expectedResult = "120 7200";
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidReturnOfDuration(){
        String actualResult = localDateWorking.timeFromLessonToLesson();
        String expectedResult = "74 4440 266400";
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
