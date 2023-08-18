package com.scaler.todolist.tasks;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        super();
        this.tasksService = tasksService;
    }

    // GET Requests:
    @GetMapping("/")
    public List<TasksEntity> getAllTasks() {
        return tasksService.getAllTasks();
    }

    // POST Requests:
    @PostMapping("/")
    public void createTask(@RequestBody CreateTaskRequestDto requestDto) throws ParseException {
        tasksService.createTask(requestDto.getName(), requestDto.getDueDate());
    }
}
