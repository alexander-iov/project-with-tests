package task13;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateWorking {

    public String formatting(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm yyyy/MM/dd");
        return LocalDateTime.now().format(dateTimeFormatter);
    }

    public LocalDateTime parsing(){
        String date = "1999/Jun/18 07:34:55 PM";
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("yyyy/LLL/dd hh:mm:ss a", Locale.US);
        return LocalDateTime.parse(date, dateTimeFormatter);
    }

    public String lessonDuration(){
        LocalTime from = LocalTime.of(20, 0);
        LocalTime to = LocalTime.of(22, 0);
        Duration duration = Duration.between(from, to);
        return duration.toMinutes() + " " + duration.toSeconds();
    }

    public String timeFromLessonToLesson(){
        LocalDateTime timeMonday = LocalDateTime.of(2021, 1, 18, 20, 0);
        LocalDateTime timeThursday = LocalDateTime.of(2021, 1, 21, 22, 0);
        Duration duration = Duration.between(timeMonday, timeThursday);
        return duration.toHours() + " " + duration.toMinutes() + " " + duration.toSeconds();
    }
}
