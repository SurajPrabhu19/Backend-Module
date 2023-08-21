package com.scaler.todolist.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scaler.todolist.notes.NotesEntity;
import com.scaler.todolist.tasks.Exceptions.TaskNotFoundException;

@Service
public class TasksService {
    List<TasksEntity> tasks;
    HashSet<Integer> taskIdSet = new HashSet<>(0, 0);

    public TasksService() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Get all tasks
     */

    public List<TasksEntity> getAllTasks() {
        return tasks;
    }

    public void createTask(String name, Date dueDate) {
        int newTaskId = tasks.size();

        TasksEntity task = new TasksEntity(newTaskId, name, dueDate, TasksStatusEnum.OPEN, new ArrayList<>());

        tasks.add(task);
        taskIdSet.add(newTaskId);
    }

    public TasksEntity getTaskbyId(int id) {
        if (!checkTaskId(id)) {
            System.out.println("Invalid Task Id: " + id);
            throw new TaskNotFoundException(id);
        }
        return tasks.get(id);
    }

    public boolean checkTaskId(int id) throws TaskNotFoundException,
            DeletedTaskException {
        if (!taskIdSet.contains(id)) {
            System.out.println("Task Id: " + id + " Not found");
            return false;
        }

        return true;
    }

    public void deleteTaskById(int id) {
        if (id < 0 || id >= tasks.size())
            throw new TaskNotFoundException(id);
        if (task.get(id) == null)
            throw new TaskDeletedexception(id);
        tasksSet.remove(tasks.get(id));
        tasks.set(id, null);
    }

    public void updateTaskById(int id, String name, Date dueDate, TasksStatusEnum status, List<NotesEntity> notes) {
        if (!checkTaskId(id)) {
            System.out.println("Invalid id: " + id);
            throw new TaskNotFoundException();
        }

        TasksEntity task = tasks.get(id);
        tasksSet.remove(task);

        if (name != null)
            task.setName(name);

        if (dueDate != null)
            task.setDueDate(dueDate);

        if (status != null)
            task.setStatus(status);

        tasksSet.add(task);

    }
}
