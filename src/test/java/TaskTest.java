import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskTest {


    @Test
    public void testSimpleTaskMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(true, actual);
    }


    @Test
    public void testSimpleTaskMatchesFullTitleTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(true, actual);
    }

    @Test
    public void testSimpleTaskMatchesFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Сказать");

        Assertions.assertEquals(false, actual);
    }


    @Test
    public void testEpicMatchesTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(true, actual);
    }

    @Test
    public void testEpicMatchesFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Пельмени");

        Assertions.assertEquals(false, actual);
    }

    @Test
    public void testMeetingMatchesTopicTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(true, actual);
    }

    @Test
    public void testMeetingMatchesProjectTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("НетоБанк");

        Assertions.assertEquals(true, actual);
    }

    @Test
    public void testMeetingMatchesFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Позвонить");

        Assertions.assertEquals(false, actual);
    }
}