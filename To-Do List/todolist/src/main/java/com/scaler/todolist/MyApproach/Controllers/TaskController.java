package com.scaler.todolist.MyApproach.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.todolist.MyApproach.Models.Note;
import com.scaler.todolist.MyApproach.Models.Task;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    // Storage/DB:
    // Keeps track of tasks with task-id = idx:
    private List<Task> taskList = new ArrayList<>();

    // Maps the task-id to Notes with note_id = idx of arraylist:
    private HashMap<Integer, List<Note>> mapTaskNotes = new HashMap<>();

    // GET request:
    @GetMapping("/{task_id}")
    public Task getTaskById(@PathVariable("task_id") String task_id) {
        // get task by id:
        int id = Integer.parseInt(task_id) - 1; // since the user will input bw 1 to N and we have store task_id
                                                // 0 to N-1 in the Map and ArrayList
        // edge case:
        if (id < 0 || id >= taskList.size()) {
            System.out.println("Index out of bounds " + id);
            return null;
        }
        return taskList.get(id);
    }

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return taskList;
    }

    @GetMapping("/{task_id}/notes")
    public List<Note> getNotes(@PathVariable String task_id) {
        int id = Integer.parseInt(task_id) - 1;
        if (mapTaskNotes.containsKey(id))
            return mapTaskNotes.get(id);
        return null;
    }

    @GetMapping("/{task_id}/notes/{note_id}")
    public Note getNotes(@PathVariable String task_id, @PathVariable String note_id) {
        int t_id = Integer.parseInt(task_id) - 1;
        int n_id = Integer.parseInt(note_id) - 1;
        if (mapTaskNotes.containsKey(t_id) && n_id < mapTaskNotes.get(t_id).size() && n_id >= 0)
            return mapTaskNotes.get(t_id).get(n_id);
        return null;
    }

    // POST Request:
    @PostMapping("/")
    public Task addNewTask(@RequestBody Task task) {
        taskList.add(task);
        int task_id = taskList.size() - 1;
        if (!mapTaskNotes.containsKey(task_id))
            mapTaskNotes.put(task_id, new ArrayList<Note>());
        return task;
    }

    @PostMapping("/{task_id}/notes")
    public Note addNewNote(@PathVariable String task_id, @RequestBody Note note) {
        int t_id = Integer.parseInt(task_id) - 1;
        if (mapTaskNotes.containsKey(t_id)) {
            mapTaskNotes.get(t_id).add(note);
            return note;
        }
        System.out.println("Task id not found");
        return null;
    }

    @DeleteMapping("{task_id}/notes/{note_id}")
    public Note deleteNote(@PathVariable String task_id, @PathVariable String note_id) {
        int t_id = Integer.parseInt(task_id) - 1;
        int n_id = Integer.parseInt(note_id) - 1;
        Note deletedNote = null;
        if (mapTaskNotes.containsKey(t_id) && n_id < mapTaskNotes.get(t_id).size() && n_id >= 0) {
            deletedNote = mapTaskNotes.get(t_id).remove(n_id);
            if (mapTaskNotes.get(t_id).size() == 0)
                mapTaskNotes.remove(t_id);
        }
        return deletedNote;
    }
}
