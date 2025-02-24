import java.util.ArrayDeque;

public class TasksBoard {

    private ArrayDeque<String> tasks;

    public TasksBoard() {
        this.tasks = new ArrayDeque<>();
    }

    public void addTask(String task) {
        tasks.addLast(task);
    }

    public void addUrgentTask(String task) {
        tasks.addFirst(task);
    }

    public void processTask() {
        tasks.removeFirst();
    }

    public void showTasks() {
        System.out.println(tasks);
    }
}
