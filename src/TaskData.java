public class TaskData {

    int id;
    String task, description;
    int deadline;

    boolean status = false;
    int importance;


    public TaskData(int id) {
        this.id = id;
    }

    public TaskData(int id, String task, int deadline) {
        this.id = id;
        this.task = task;
        this.deadline = deadline;
    }

    public TaskData(String task, String description, int deadline) {
        this.task = task;
        this.description = description;
        this.deadline = deadline;
    }

    public TaskData(String task) {
        this.task = task;
    }

    public TaskData(int id, String task) {
        this.id = id;
        this.task = task;
    }

    public TaskData(String task, String description) {
        this.task = task;
        this.description = description;
    }

    public TaskData(int id, String task, String description) {
        this.id = id;
        this.task = task;
        this.description = description;
    }


    public TaskData(int id, String task, String description, int deadline) {
        this.id = id;
        this.task = task;
        this.description = description;
        this.deadline = deadline;
    }


    public String getDescription() {
        return description;
    }

    public String getTask() {
        return task;
    }

    public boolean isStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public int getImportance() {
        return importance;
    }

    public int getDeadline() {
        return deadline;
    }

    public boolean getStatus() {
        return status;
    }
}
