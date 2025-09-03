import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSeveralTasksMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTasksMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Пельмени");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasksEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void shouldGetMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
        Assertions.assertEquals("Приложение НетоБанка", meeting.getProject());
        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());
    }

    @Test
    public void shouldGetTitleSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertEquals("Позвонить родителям", simpleTask.getTitle());
    }

    @Test
    public void shouldGetTaskId() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertEquals(5, simpleTask.getId());

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertEquals(55, epic.getId());

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        Assertions.assertEquals(555, meeting.getId());
    }

    @Test
    public void shouldEqualsAndHashCode() {
        SimpleTask task1 = new SimpleTask(55, "SimpleTask");
        SimpleTask task2 = new SimpleTask(55, "Epic");
        SimpleTask task3 = new SimpleTask(555, "Meeting");

        Assertions.assertEquals(task1, task2);
        Assertions.assertEquals(task1.hashCode(), task2.hashCode());

        Assertions.assertNotEquals(task1, task3);
        Assertions.assertNotEquals(task1.hashCode(), task3.hashCode());

        Assertions.assertEquals(true, task1.equals(task1));
        Assertions.assertEquals(false, task1.equals(null));

        Object object = new Object();
        Assertions.assertEquals(false, task1.equals(object));
    }

    @Test
    public void shouldTaskMatches() {
        Task task = new Task(10);

        Assertions.assertEquals(false, task.matches("Позвонить"));
    }
}
