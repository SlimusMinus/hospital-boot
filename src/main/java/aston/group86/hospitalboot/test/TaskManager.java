package aston.group86.hospitalboot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskManager {

  private final List<Task> tasks = new CopyOnWriteArrayList<>();

  public boolean addTask(Task task) {
    if (task == null || task.name == null || task.name.isEmpty()) {
      log.warn("Task {} or name is null", task);
      return false;
    }
    return tasks.add(task);
  }

  public boolean removeTask(Task task) {
    return tasks.remove(task);
  }

  public List<Task> getTasks() {
    return new ArrayList<>(tasks);
  }

  public Task getTaskByIndex(int index) {
    if (index >= tasks.size() || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return tasks.get(index);
  }

  public String getAllTasksAsString() {
    return tasks.stream()
        .map(task -> task.name + " " + task.description + ",")
        .collect(Collectors.joining("/n"));
  }

  @Getter
  @Setter
  @AllArgsConstructor
  public class Task {

    private String name;
    private String description;

    public Task(String name) {
      this.name = name;
    }
  }

}